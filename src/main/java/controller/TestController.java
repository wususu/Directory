package controller;

import java.io.File;
import java.io.IOException;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.TableGenerator;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.xmlrpc.base.Array;

import entity.Contacter;
import entity.Image;
import entity.ContacterAndImage;
import entity.Groups;
import entity.Product;
import service.ContacterService;
import service.GroupsService;
import service.ImageService;
import service.JSONFormatService;
import tools.DataFormat;

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
	
	@Autowired
	JSONFormatService jsonFormatService;
	
	private static final Log logger = LogFactory.getLog(TestController.class);


	@RequestMapping(value="/test")
	@Transactional
	@ResponseBody
	public HashMap<String, Object> test(){
		Contacter contacter = contacterService.get(1);
		return jsonFormatService.getContacterDetails(contacter);
	}
	
	@RequestMapping(value="/test1/{page}")
	@ResponseBody
	@Transactional
	public Object test1(@PathVariable Integer page){
		Object list = contacterService.getContacterByPage(page);
		return list;
	}
	


}
