package com.argabi.firstproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {


	//@RequestMapping(value="/greeting/hello", method=RequestMethod.GET)
	@RequestMapping("/")
	public String hello(@RequestParam(value="q" ,required=false) String searchQ) {
		return "u r in the root url Y  " + searchQ;
	}
	
	@RequestMapping("/ali") 
	public String ali() {
		return "hi Ali";
	}
}
