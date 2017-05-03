package controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
