package com.argabi.GettingFamiliarwithRouting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 

@RequestMapping("/coding")
public class CodingController {
	
	//http://localhost:8080/coding' display a text that says 'Hello Coding Dojo!'.
	@RequestMapping("")
	public String work1() {
		return "Hello Coding Dojo!";
	}
	
	//ttp://localhost:8080/coding/python' display a text that says 'Python/Django was awesome!'.
	@RequestMapping("/python")
	public String work2() {
		return "Python/Django was awesome!";
	}
	
	//'http://localhost:8080/coding/java' display a text that says 'Java/Spring is better!'.
	@RequestMapping("/java")
	public String work3() {
		return "Java/Spring is better!";
	}
	
	
}



