package controller;





import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;
import javax.xml.bind.Marshaller.Listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.descriptor.java.MutabilityPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


	
	@RequestMapping(value="/")
	public String test(@ModelAttribute final ContacterAndImage test, final HttpServletRequest request, final Model model){
		return "Index";
	}
	


}
