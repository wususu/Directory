package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Groups;
import service.GroupsService;

@Controller
public class GroupController {
	
	@Autowired
	@Qualifier("groupsServiceImpl")
	GroupsService groupsService;
	
	@RequestMapping(value="/allGroups")
	public ModelAndView getAllGroups(){
		List<Groups> groupsList = groupsService.getAll();
		for (Groups groups : groupsList) {
			System.out.println(groups + groups.getName());
		}
		return new ModelAndView("GroupsList", "groupsList", groupsList);
	}
}
