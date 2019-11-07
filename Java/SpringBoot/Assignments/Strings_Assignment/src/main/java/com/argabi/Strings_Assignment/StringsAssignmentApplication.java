package com.argabi.Strings_Assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController 
public class StringsAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsAssignmentApplication.class, args);
	}

	
	

	@RequestMapping("/")
	public String urlRoot () {
		return "Hello Client! How are you doing ?";
	}
	
	
	@RequestMapping("/random")
	public String urlRandom () {
		return "Spring boot is great! So easy to just respond with strings";
	}
	
	
}
