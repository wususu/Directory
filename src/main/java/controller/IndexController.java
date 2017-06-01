package controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;

import org.apache.log4j.TTCCLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.ContacterAndImage;
import entity.Groups;
import entity.Image;
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
	public String test(@ModelAttribute final ContacterAndImage test, final HttpServletRequest request, final Model model){
		return "Index";
	}
}
