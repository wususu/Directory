package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import entity.User;
import service.UserService;

public class BaseAuthorizeController extends BaseController{
	
	@Autowired
	@Qualifier("userServiceImpl")
	UserService userService;
	
	
	public String login(User user, HttpSession httpSession){
		if (user != null) {
			user.setPassWord("");
			httpSession.setAttribute("user", user);
			System.out.println("密码正确");
			return "redirect:/index";
		}else {
			return "redirect:/login";
		}
	}
	
	public String logout(HttpSession httpSession) {
		httpSession.setAttribute("user","");
		return "redirect:/login";
	}
}
