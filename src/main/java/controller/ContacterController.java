package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.loader.custom.Return;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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

import com.sun.mail.handlers.message_rfc822;

import entity.Contacter;
import entity.ContacterAndImage;
import entity.Groups;
import service.ContacterService;
import service.GroupsService;
import service.ImageService;
import tools.StringUtils;

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
	public String addContacter(@ModelAttribute final ContacterAndImage test, final HttpServletRequest request, final Model model) {
		final Contacter contacter = test.getContacter();
		final MultipartFile picture= test.getImage().getPicture();
		// 保存图片
		if (!picture.isEmpty() && contacter.getName() != null) {
			final String picName = imageService.getContacterPicName(contacter.getId(), contacter.getName());
			final String picPath = request.getServletContext().getRealPath("/image") + "/" +picName;
			if (imageService.saveImage(picture, picPath)) {
				System.out.println(picPath);
				contacter.setPic(picPath);
			}
		}
		contacterService.save(contacter);
		model.addAttribute("contacter", contacter);
		return "redirect:/contacter/"+contacter.getId();
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
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateContacter(@ModelAttribute Contacter contacter){
		try{
			contacterService.update(contacter);
		}catch ( Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		return "redirect:/contacter/"+ contacter.getId();
	}
	
	/**
	 * 获取联系人详细信息
	 * @param id
	 * @return JSON
	 */
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getContacter(@PathVariable final Integer id){
		Map<String, Object> response =  contacterService.getContacterData(id);
		return response;
	}
	
	/**
	 * 获取所有联系人
	 * @param model
	 * @return JSON
	 */
	@RequestMapping(value="/all", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, List<Map<String, Object>>> getAllContacter(){
		List<Map<String, Object>> list  = contacterService.getAllContacters();
		Map<String, List<Map<String, Object>>> response = new HashMap<String, List<Map<String, Object>>>();
		response.put(Contacter.class.getSimpleName(), list);
		return response;
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
				response.put("result", "ok");
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
	public Map<String, String> addGroups(@RequestParam(name="group_id") Integer groupId,
			@RequestParam(name="contacter_id") Integer contacterId){
		Map<String, String> response = new HashMap<String, String>();
		response.put("result", "error");
		try{
			Contacter contacter = contacterService.get(contacterId);
			Groups groups = groupsService.get(groupId);
			if (!contacterService.findGroups(contacter, groups)) {
				contacterService.addGroups(contacter, groups);
				response.put("result", "ok");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.put("result", "error");
		}
		return response;
	}
}
