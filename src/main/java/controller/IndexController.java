package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.ContacterAndImage;
import service.ContacterService;
import service.GroupsService;
import service.ImageService;
import service.JSONFormatService;

@Controller
public class IndexController {
	@Autowired
	@Qualifier("contacterServiceImpl")
	ContacterService contacterService;
	
	@Autowired
	@Qualifier("groupsServiceImpl")
	GroupsService groupsService;
	
	@Autowired
	@Qualifier("imageServiceImpl")
	ImageService imageService;
	
	@Autowired
	JSONFormatService jsonFormatService;
	
	
	@RequestMapping(value="/")
	public String index(@ModelAttribute final ContacterAndImage test, final HttpServletRequest request, final Model model){
		return "Index";
	}
}
