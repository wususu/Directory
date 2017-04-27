package controller;

import java.io.File;
import java.io.IOException;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import entity.Contacter;
import entity.Image;
import entity.ContacterAndImage;
import entity.Groups;
import entity.Product;
import service.ContacterService;
import service.GroupsService;
import service.ImageService;

@Controller
public class TestController {
	
	
	@Autowired
	@Qualifier("contacterServiceImpl")
	ContacterService contacterService;
	
	@Autowired
	@Qualifier("groupsServiceImpl")
	GroupsService groupsService;
	
	@Autowired
	@Qualifier("imageServiceImpl")
	ImageService imageService;
	
	private static final Log logger = LogFactory.getLog(TestController.class);


	@RequestMapping(value="/test")
	@Transactional
	@ResponseBody
	public Map<String, List<Map<String, Object>>> test(){
		Groups groups = groupsService.get(1);
		Set<Contacter> contacter = groupsService.getContacters(groups);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, List<Map<String, Object>>> map = new HashMap<String, List<Map<String, Object>>>();
		
		for (Contacter contacter2 : contacter) {
			list.add(contacter2.toMap());
		}
		map.put(Contacter.class.getSimpleName(), list);
		return map;
	}
	


}
