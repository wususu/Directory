package controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.taglibs.standard.tag.common.xml.IfTag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Contacter;
import entity.Groups;
import javassist.expr.NewArray;
import service.ContacterService;
import service.GroupsService;

@Controller
public class TestController {
	
	
	@Autowired
	@Qualifier("contacterServiceImpl")
	ContacterService contacterService;
	
	@Autowired
	@Qualifier("groupsServiceImpl")
	GroupsService groupsService;
	
	private static final Log logger = LogFactory.getLog(TestController.class);
	
	@RequestMapping(value = "/test_contacter")
	// 为该方法启动数据库事物, 从额允许检索懒惰集合
	@Transactional
	public void testContacter(){
		logger.info("father, i'am in");
		
		List<Contacter> contacters = contacterService.getAll();
		Iterator<Contacter> iterator2 = contacters.iterator();
		logger.info(contacters.size());
		while (iterator2.hasNext()){
			Contacter contacter = iterator2.next();
			System.out.println(contacter + contacter.getName());
		}
		
		List<Groups> groups = groupsService.getAll();
		Iterator<Groups> iterator = groups.iterator();
		logger.info(groups.size());
		while (iterator.hasNext()){
			Groups groups2 = iterator.next();
			System.out.println(groups2 + groups2.getName());
		}
		Integer bb = new Integer(null);
		System.out.println(bb);
		
		logger.info("daddy,i'am out");
	}

}
