package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Contacter;
import entity.Groups;
import service.GroupsService;
import service.JSONFormatService;

@Controller
@RequestMapping(value="/groups")
public class GroupController {
	
	@Autowired
	@Qualifier("groupsServiceImpl")
	GroupsService groupsService;
	
	@Autowired
	private JSONFormatService jsonFormatService;
	
	@RequestMapping(value="/all")
	@ResponseBody
	public Object getAllGroups(){
		List<Groups> groupsList = groupsService.getAll();
		return jsonFormatService.formatGroupsListToJSON(groupsList);
	}
	
	@RequestMapping(value="/get/{id}")
	@ResponseBody
	@Transactional
	public HashMap<String, Object> getGroupsDetails(@PathVariable int id){
		Groups groups = groupsService.get(id);
		if (groups == null) {
			return jsonFormatService.getErrorMessage("index out of range");
		}
		return jsonFormatService.getGroupDetails(groups);
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> newGroup(Groups group){
		Map<String, String> resp = new HashMap<String, String>();
		if (groupsService.get(group.getName()) == null) {
			System.out.println(group.getName());
			group.setContatcerCount(0);
			groupsService.save(group);
			resp.put("result", "success");
		}else {
			resp.put("result", "error");
		}
		return resp;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> deleteGroup(@RequestParam("id") Integer id){
		Map<String, String> resp = new HashMap<String, String>();
		System.err.println(id);
		Groups group = groupsService.get(id);
		if (group != null) {
			group.setContacters(null);
			groupsService.delete(group);
			resp.put("result", "success");
		}else {
			resp.put("result", "error");
		}
		return resp;
	}
	
	@RequestMapping(value="/test")
	@ResponseBody
	public Object test(){
		Groups group = groupsService.get(1);

		List<Contacter> contacterList =  groupsService.getByPage(group, 1, 5);
		for (Contacter contacter : contacterList) {
			System.out.println(contacter.getName());
		}
		return contacterList;
	}
}
