package com.argabi.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AliController {

	int  theCounter = 0;
	
	//index
	@RequestMapping("/")
	public String home(HttpSession session ) {
		
		//adding seasion
		session.setAttribute("count", theCounter++); // add session's value
		
		
		//reading session
		/////////////////////////////////////
		Integer count = (Integer) session.getAttribute("count"); // get session's Value , session always is an opject data type so u have to  convert it
		System.out.println(count);
		/////////////////////////////////////
		
		return "index.jsp";
	}
	
	
	//display counter page
	@RequestMapping("/counter")
	public String counterPage(Model model) {
		model.addAttribute("VisiterNumber", theCounter);
		return "counterPage.jsp";
	}
	
	
	
}
