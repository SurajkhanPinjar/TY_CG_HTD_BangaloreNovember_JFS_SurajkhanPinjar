package com.capgemini.springmvc.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;

import org.omg.IOP.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.capgemini.springmvc.beans.User;

@Controller
public class SpringController {
	@Autowired
	private ServletContext context;
	
	@RequestMapping("/hello")
	public String hello(ModelMap map) {
		map.addAttribute("msg", "Hello....!");
		return "index";
	}
	
	
//	@RequestMapping(path = "/query" , method = RequestMethod.GET)		// its just similar as overriding do get Method
	//@req param converts 
	@GetMapping("/query")												//its similar to above Req Mapping
	public String query(@RequestParam("name")String name, @RequestParam("age")int age, ModelMap map) {
		
		map.addAttribute("name",name);
		map.addAttribute("age" , age);
		
		return "query";
	}
	
	
	@GetMapping("/formm")
	public String form () {
		return "formm" ;
	}
	
	
	@PostMapping("/formm") 	//Get the Body Of Formwew
	public String form(User user, ModelMap map) {
		map.addAttribute("name", user.getName());
		map.addAttribute("email",user.getEmail());
		map.addAttribute("password",user.getPassword());
		map.addAttribute("gender", user.getPassword());
		return "formm";
	}
	
	//create cookie
	@GetMapping("/createCookie")
	public String createCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("name", "khan");				//Creating cookie
		response.addCookie(cookie);
		return "createCookie";
	}
	
	@GetMapping("/getCookie")
	public String getCookie(@CookieValue(name = "name", required = false)String name, ModelMap map ) {
		if (name != null) 
			map.addAttribute("name", name);
		else 
			map.addAttribute("name", "Cookie Value Not Present");
		return "getCookie" ;
	}
	
	@GetMapping("/path/{movie}/{hero}")
	public String path(@PathVariable("movie") String movie,@PathVariable("hero") String hero, ModelMap map) {
		map.addAttribute("movie", movie);
		map.addAttribute("hero", hero);
		
		return "pathvalue";
	}
	
	
	
	
	@GetMapping("/forward")
	public String forward() {
		
		return "forward:hello";
	}
	
	
	
	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:https://www.google.com";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	
	@PostMapping("/login")
	public String login(String username, String password, HttpServletRequest request, ModelMap map) {
		if (username.equals("user") && password.equals("qwerty")) {
			User user = new User();
			user.setName(username);
			user.setEmail("usermai@gmail.com");
			user.setPassword(password);
			user.setGender("M");
			
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
//			request.getSession();
			map.addAttribute("msg","user loged in");
			return "home";
			
		} else {
			map.addAttribute("msg", "Credentials Invalid");
			return "login";
		}
		
	}
	
	//Session Creration
	@GetMapping("home")
	public String home(@SessionAttribute(name = "user", required = false) User user ) {
		if(user != null) {
			return "home";
		}
		return "login";
	}
	
	//Set context
	@GetMapping("/appattribute")
	public String setAppAttribute() {
		context.setAttribute("msg", new Object());   			//simply we can send any object
		return "setcontext";
	}
	
	@GetMapping("/getappattribute")
	public String getAppAttribute() {
		System.out.println(context.getAttribute("msg"));
		return "getcontext";
	}
	
}

			




//
