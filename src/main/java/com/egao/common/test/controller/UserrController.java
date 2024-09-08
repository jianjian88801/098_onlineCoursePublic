package com.egao.common.test.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.egao.common.core.web.BaseController;
import com.egao.common.system.entity.UserTwo;
import com.egao.common.test.service.MenurService;

@Controller
@RequestMapping("/users")
public class UserrController extends BaseController{
	
	@Autowired
	private MenurService menurService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		Subject subject = SecurityUtils.getSubject();
        Object object = subject.getPrincipal();
        if(object != null) {
        	model.addAttribute("user", (UserTwo)object);
    		model.addAttribute("menu", menurService.list());
    		return "/user/index.html";
        }else {
        	UserTwo user2 = new UserTwo();
			user2.setUsername("游客");
			user2.setUserId(-1);
			model.addAttribute("user", user2);
			model.addAttribute("menu", menurService.list());
			return "default/login.html";
        }
		
	}
	
	@RequestMapping("/order")
	public String order(Model model) {
		Subject subject = SecurityUtils.getSubject();
        Object object = subject.getPrincipal();
		if(object != null) {
			model.addAttribute("user", (UserTwo)object);
    		model.addAttribute("menu", menurService.list());
    		return "/user/order.html";
		}else {
			UserTwo user2 = new UserTwo();
			user2.setUsername("游客");
			user2.setUserId(-1);
			model.addAttribute("user", user2);
			model.addAttribute("menu", menurService.list());
			return "default/login.html";
		}
	}
	
	@RequestMapping("/notice")
	public String notice(Model model) {
		Subject subject = SecurityUtils.getSubject();
        Object object = subject.getPrincipal();
		if(object != null) {
			model.addAttribute("user", (UserTwo)object);
    		model.addAttribute("menu", menurService.list());
    		return "/user/notice.html";
		}else {
			UserTwo user2 = new UserTwo();
			user2.setUsername("游客");
			user2.setUserId(-1);
			model.addAttribute("user", user2);
			model.addAttribute("menu", menurService.list());
			return "default/login.html";
		}
	}
	
	
	@RequestMapping("/release")
	public String release(Model model) {
		Subject subject = SecurityUtils.getSubject();
        Object object = subject.getPrincipal();
		if(object != null) {
			model.addAttribute("user", (UserTwo)object);
    		model.addAttribute("menu", menurService.list());
    		return "/user/release.html";
		}else {
			UserTwo user2 = new UserTwo();
			user2.setUsername("游客");
			user2.setUserId(-1);
			model.addAttribute("user", user2);
			model.addAttribute("menu", menurService.list());
			return "default/login.html";
		}
	}
	

}
