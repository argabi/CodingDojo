package com.argabi.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;  
import java.util.Date; 

@Controller
public class AliController {
		//index 
		@RequestMapping("")
		public String showTime() {
			return "index.jsp";
		}
	
		//Date
		@RequestMapping("/date")
		public String showDate(Model model) {
			model.addAttribute("theDate",new java.util.Date());
			return "datePage.jsp";
		}
		
		//Time
		@RequestMapping("/time")
		public String showTime(Model model) {
			Date date = new Date();  
		    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
		    String strDate= formatter.format(date); 
			model.addAttribute("theTime",strDate);
			return "timePage.jsp";
		}
}
