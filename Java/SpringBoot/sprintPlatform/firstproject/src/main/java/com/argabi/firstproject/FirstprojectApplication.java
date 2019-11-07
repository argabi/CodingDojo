package com.argabi.firstproject;

//ali-3
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // ali-1
public class FirstprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}

	
	
	@RequestMapping("/") //ali-2  root request
	public String hello() {
		return "Hello Aliq";
	}
}
