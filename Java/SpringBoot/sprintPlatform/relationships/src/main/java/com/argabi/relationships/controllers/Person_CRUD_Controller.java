package com.argabi.relationships.controllers;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.argabi.relationships.models.Person;
import com.argabi.relationships.services.PersonService;

@Controller
public class Person_CRUD_Controller {
		//CRUD for person
	
		private final PersonService person_Service;
	    
	    public Person_CRUD_Controller(PersonService person_Service) {
	        this.person_Service = person_Service;
	    }
    
	    
	// create a new person
	@RequestMapping(value="/acreatePerson", method=RequestMethod.POST)
  
    public String create(@Valid @ModelAttribute("personForm") Person thePerson, BindingResult result) {
    	
        if (result.hasErrors()) {
            return "addPerson.jsp"; //found error , reload the page
        } else {
        	person_Service.createBook(thePerson);
            return "redirect:/"; // home
        }
    }
	
}
