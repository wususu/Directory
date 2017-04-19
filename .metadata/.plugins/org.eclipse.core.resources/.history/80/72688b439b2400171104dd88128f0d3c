package controller;


import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;

@Controller
public class UserController extends BaseAuthorizeController{
	
	private static final Log logger = LogFactory.getLog(UserController.class);

	public UserController() {
		// TODO Auto-generated constructor stub
		logger.info("Daddy, i'am in !!");
	}
	
	@RequestMapping(value = "/login")
	public String userLogin(Model model){
		model.addAttribute( new User());
		return "LoginForm";
	}
	
	@RequestMapping(value="/logout")
	public String userLogout(HttpSession httpSession){
		return logout(httpSession);
	}
	
	@RequestMapping(value = "/check")
	public String userCheck( @ModelAttribute User user, Model model, HttpSession httpSession ) {
		if (userService.checkUser(user.getUserName(), user.getPassWord())) {
			return login(user, httpSession);
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/index")
	public  String Test(HttpSession httpSession, Model model){
		try{
			User user = (User)httpSession.getAttribute("user");
			System.out.println(user.getUserName());
			model.addAttribute("user", user);
			model.addAttribute("username", "hello");
			return "Index";
		}catch (ClassCastException e) {
			// TODO: handle exception
			return "redirect:/login";
		}catch (NullPointerException e) {
			// TODO: handle exception
			return "redirect:/login";
		}
	}
}
