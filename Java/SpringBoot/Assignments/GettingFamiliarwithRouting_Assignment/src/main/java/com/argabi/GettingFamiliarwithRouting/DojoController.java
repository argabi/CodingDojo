package com.argabi.GettingFamiliarwithRouting;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 

public class DojoController {
// use the @PathVariable
	
//'http://localhost:8080/dojo' display a text that says 'The dojo is awesome!'.	
	
	@RequestMapping("/{theName}")
	
    public String showLesson(@PathVariable("theName") String theName){
		
		if (theName.equals("dojo"))
		{
			return "The dojo is awesome! - (PathVariable)";
		}
		else if (theName.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California - (PathVariable)";
		}
		else if (theName.equals("san-jose")) {
			return "SJ dojo is the headquarters - (PathVariable)";
		}
		else
		{
			return "you typed: " +theName ;
		}
		
    	
    }
	
	
}

