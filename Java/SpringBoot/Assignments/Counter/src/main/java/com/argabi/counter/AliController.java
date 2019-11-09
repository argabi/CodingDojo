package com.argabi.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AliController {
	
	//index
	@RequestMapping("/")
	public String home(HttpSession session ) {
		
		// get session's Value , session always is an opject data type so u have to  convert it
		Integer count = (Integer) session.getAttribute("sessionCountter"); 
		
		// new session
		if (count==null) {
			count =0;
			session.setAttribute("sessionCountter", count); // count = 0
		}
		
		session.setAttribute("sessionCountter", count+1);
		
		return "index.jsp";
	}
	
	
	//display counter page
	@RequestMapping("/counter")
	public String counterPage(HttpSession session) {
		
		session.getAttribute("sessionCountter");  // < c:out value="${sessionCountter}" />
		return "counterPage.jsp";
	}
	
	
	
}
