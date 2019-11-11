package com.argabi.relationships.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.argabi.relationships.models.Person;

@Controller
public class MainController {
	//Routing 
	
	//root  >> HTML index page
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	//HTML new person page
	@RequestMapping("/person/new")
	public String addPersonPage(@ModelAttribute("personForm") Person thePerson)   { 
		return "addPerson.jsp";
	}
	
	//HTML new licenses page
	@RequestMapping("/licenses/new")
	public String addLicensesPage() {
		return "addLicenses.jsp";
	}
	
}
