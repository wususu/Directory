package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.jpa.criteria.expression.function.AggregationFunction.COUNT;
import org.hibernate.loader.custom.Return;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.SavepointManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import entity.Contacter;
import entity.ContacterAndImage;
import entity.Groups;
import service.ContacterService;
import service.ContacterServiceImpl;
import service.GroupsService;
import service.ImageService;
import service.JSONFormatService;

@Controller
@RequestMapping(value="/contacter")
public class ContacterController {

	@Autowired
	@Qualifier("imageServiceImpl")
	private ImageService imageService;
	
	@Autowired
	@Qualifier("contacterServiceImpl")
	private ContacterService contacterService;
	
	@Autowired
	@Qualifier("groupsServiceImpl")
	private GroupsService groupsService;
	
	@Autowired
	private JSONFormatService jsonFormatService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addContacterForm(final Model model, final HttpServletRequest request){
		model.addAttribute(new ContacterAndImage());
		return "ContacterForm";
	}
	
	/**
	 * 新增联系人
	 * @param test
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String addContacter(@ModelAttribute  ContacterAndImage form, final HttpServletRequest request, final Model model) {
		final Contacter contacter = form.getContacter();
		final MultipartFile picture= form.getImage().getPicture();
		// 保存图片
		if (!picture.isEmpty() && contacter.getName() != null) {
			final String picName = imageService.getContacterPicName(contacter.getId(), contacter.getName());
			final String picPath = "/home/janke/workspace/Demo/WebContent/WEB-INF/image" + "/" +picName;
			if (imageService.saveImage(picture, picPath)) {
				System.out.println(picPath);
				contacter.setPic(picPath);
			}
		}
		contacterService.save(contacter);
		model.addAttribute("contacter", contacter);
		return "redirect:/contacter/get/"+contacter.getId();
	}
	
	/**
	 * 修改头像
	 * @param img
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/image/update", method=RequestMethod.POST)
	public Map<String, String> saveImage(@RequestParam(value="img")MultipartFile img, @RequestParam(value="id") Integer id){
		Map<String, String> resp = new HashMap<String, String>();
		if (img.getOriginalFilename().isEmpty()){
			return null;
		}else {
			Contacter contacter = contacterService.get(id);
			if (!img.isEmpty() && contacter.getName() != null) {
				final String picName = imageService.getContacterPicName(contacter.getId(), contacter.getName());
				final String picPath = "/home/janke/workspace/Demo/WebContent/WEB-INF/image" + "/" +picName;
				if (imageService.saveImage(img, picPath)) {
					System.out.println(picPath);
					contacter.setPic(picPath);
					contacterService.update(contacter);
					resp.put("result", "success");
					return resp;
				}
			}
		}
		resp.put("result", "error");
		return resp;
	}
	
	/**
	 * 修改联系人视图
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public  ModelAndView  updateContacterForm(@PathVariable final Integer id, final Model model) {
		Contacter contacter = contacterService.get(id);
		return new ModelAndView("EditContacter", "contacter", contacter);
	}
	
	/**
	 * 修改联系人
	 * @param contacter
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public Map<String, String> updateContacter(@ModelAttribute Contacter contacter){
		Map<String, String> respon = new HashMap<String, String>();
//		System.out.println(id);
		if (contacter!=null) {
			contacter.setPic(contacterService.get(contacter.getId()).getPic());
			contacterService.update(contacter);
			respon.put("result", "success");
			return respon;
		}
		respon.put("result", "error");
		return respon;
	}
	
	/**
	 * 获取联系人详细信息
	 * @param id
	 * @return JSON
	 */
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	@ResponseBody
	@Transactional
	public Map<String, Object> getContacter(@PathVariable final Integer id){
		Contacter contacter = contacterService.get(id);
		if (contacter == null) {
			return jsonFormatService.getErrorMessage("id is out of range");
		}
		return jsonFormatService.getContacterDetails(contacter);
	}
	
	/**
	 * 按页获取联系人
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/page/{page}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getContactersByPage(@PathVariable int page){
		List<Contacter> list = contacterService.getContacterByPage(page);
		return jsonFormatService.formatContactersListToJSON(list);
	}
	
	/**
	 * 获取所有联系人
	 * @param model
	 * @return JSON
	 */
	@RequestMapping(value="/all", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAllContacter(){
		List<Contacter> contactersList = contacterService.getAll();
		return jsonFormatService.formatContactersListToJSON(contactersList);
	}
	
	/**
	 * 将联系人移出分组
	 * @param groupId
	 * @param contacterId
	 * @return JSON
	 */
	@RequestMapping(value="/removeGroups", method=RequestMethod.POST)
	@ResponseBody
	@Transactional
	public Map<String, String> removeGroups(@RequestParam(value="group_id")  Integer groupId, 
			@RequestParam(value="contacter_id") Integer contacterId){
		Map<String, String> response = new HashMap<String, String>();
		try{
			Contacter contacter = contacterService.get(contacterId);
			Groups groups = groupsService.get(groupId);
			if (contacterService.findGroups(contacter, groups)) {
				contacterService.deleteGroups(contacter, groups);
				response.put("result", "success");
			}else {
				response.put("result", "error");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.put("result", "error");
		}
		return response;
	}
	
	/**
	 * 给联系人添加分组
	 * @param groupId
	 * @param contacterId
	 * @return JSON
	 */
	@RequestMapping(value="/addGroups", method=RequestMethod.POST)
	@Transactional
	@ResponseBody
	public Map<String, String> addGroups(@RequestParam(name="group_list[]") Integer[] groupIdList,
			@RequestParam(name="contacter_id") Integer contacterId){
		Map<String, String> response = new HashMap<String, String>();
		try{
			Contacter contacter = contacterService.get(contacterId);
			for (Integer groupId : groupIdList) {
				Groups groups = groupsService.get(groupId);
				if (!contacterService.findGroups(contacter, groups)) {
					contacterService.addGroups(contacter, groups);
				}
			}
			response.put("result", "success");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.put("result", "error");
		}
		return response;
	}
	
	/**
	 * 联系人总数
	 * @return
	 */
	@RequestMapping(value="/count", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Long> getContacterCount(){
		Map<String, Long> response = new HashMap<String, Long>();
		Long  count = contacterService.count();
		Long page = (count + ContacterServiceImpl.numPerPage -1) / ContacterServiceImpl.numPerPage;
		response.put("page", page);
		response.put("count", count);
		return response;
	}
	
	/**
	 * 根据号码搜索
	 * @param matcher
	 * @return
	 */
	@Transactional
	@ResponseBody
	@RequestMapping(value="/find/{matcher}")
	public Object findByPhoneNumber(@PathVariable Integer matcher){
		List<Contacter> cellPhoneContacter =  contacterService.findByCellphone(matcher);
		List<Contacter> homeTel = contacterService.findByHomeTel(matcher);
		for (Contacter contacter : homeTel) {
			if (!cellPhoneContacter.contains(contacter)) {
				cellPhoneContacter.add(contacter);
			}
		}
		return jsonFormatService.formatContactersListToJSON(cellPhoneContacter);
	}
	
	/**
	 * 根据用户名搜索
	 * @param matcher
	 * @return
	 */
	@Transactional
	@ResponseBody
	@RequestMapping(value="/name/{matcher}")
	public Object findByName(@PathVariable String matcher){
		List<Contacter> nameContacter =  contacterService.findByName(matcher);
		return jsonFormatService.formatContactersListToJSON(nameContacter);
	}
	
	@Transactional
	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public Map<String, String> delete(@RequestParam("id") Integer id){
		System.out.println(id);
		Map<String,String> respon = new HashMap<String, String>();
		Contacter contacter = contacterService.get(id);
		List<Groups> groupList = new ArrayList<Groups>(contacter.getGroupList());
		for (Groups groups : groupList) {
			groups.setContatcerCount(groups.getContacterCount()-1);
		}
		contacter.setGroups(null);
		contacterService.delete(contacter);
		respon.put("result", "success");
		return respon;
	}
	
	@ResponseBody
	@Transactional
	@RequestMapping(value="/get/group/{groupId}")
	public Object TTCCLayout(@PathVariable Integer groupId){
		Groups groups = groupsService.get(groupId);
		if (groups != null) {
			return jsonFormatService.formatContactersListToJSON(contacterService.getContacterByGroup(groups));
		}
		return null;
	}
}
