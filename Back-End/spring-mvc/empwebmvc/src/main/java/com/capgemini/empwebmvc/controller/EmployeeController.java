package com.capgemini.empwebmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.capgemini.empwebmvc.beans.EmployeeBean;
import com.capgemini.empwebmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService Service;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(String email, String password, ModelMap map, HttpServletRequest request) {
		EmployeeBean bean = Service.auth(email, password);
		if (bean == null) {
			map.addAttribute("msg", "Invalid Credentials!!"); // sending a msg
			return "login";
		}
		HttpSession session = request.getSession();
		session.setAttribute("bean", bean);
		return "home";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/register")
	public String register(EmployeeBean bean, ModelMap map) {
		boolean check = Service.register(bean);
		if (check) {
			map.addAttribute("msg", "you have Registered Successfully :)");

		} else {
			map.addAttribute("msg", "This Email Already Exist :(");
		}

		return "login";

	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session ,ModelMap map) {
		
		session.invalidate();
		map.addAttribute("msg", "Logout Successfully");
		return "login";
	}
	
	@GetMapping("/changepassword")
	public String changePassword(@SessionAttribute(name ="bean", required = false)EmployeeBean bean ) {
		if (bean != null) 
			return "changepassword";
		else 
			return "login";
	}
	
	@PostMapping("/changepassword")
	public String changePassword(@SessionAttribute("bean")EmployeeBean bean , String password, ModelMap map) {
//		EmployeeBean bean = (EmployeeBean) session.getAttribute("bean");
		
		boolean check = Service.changePassword(bean.getEid(), password);
		if (check) {
			map.addAttribute("mess", "Password Changed Successfully");
		} else {
			map.addAttribute("mess", "Password cannot be Changed");
		}
		return "home";
		
		}
	
	@GetMapping("/search")
	public String search(@RequestParam("key")String key, ModelMap map,
			@SessionAttribute(name ="bean", required = false)EmployeeBean bean ) {
		if(bean != null) {
			List<EmployeeBean> list = Service.getEmployee(key);
			map.addAttribute("list", list);
			return "home";
		} else {
			return "login";
		}
	}
	
		
	
	
	
	
	
	}


