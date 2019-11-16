package com.argabi.taskmanager.controllers;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.argabi.taskmanager.models.User;
import com.argabi.taskmanager.services.UserService;
import com.argabi.taskmanager.validator.UserValidator;

@Controller
public class UserController {

private UserService userService;
private UserValidator userValidator;

    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService; 
        this.userValidator = userValidator;
    }
    
    
    //post
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
    	
    	userValidator.validate(user, result); //for match password 
    	
    	
    	//iS Email aleady registed  is it exists in DB ?
    	if (userService.findByEmail(user.getEmail()) != null){ //user.getEmail() from HTML FORM field
    		result.rejectValue("email", "error.user", "This Email already registered.");
    	}
    	
    	//to remove'?' from the name is found
    	//////////user.setName(user.getName().replaceAll("\\\\?", ""));
    	
    	if (result.hasErrors()) {
            return "index.jsp";
        }
    	
        userService.userRegistration(user);// register a new user
        
        model.addAttribute("registrationMessage", "You Registered Successful!");
        

        return "index.jsp";
    }
     
    
    // GET
    @RequestMapping("/")//login
    public String index(@Valid @ModelAttribute("user") User user,
    		@RequestParam(value="error", required=false) String error,
    		@RequestParam(value="logout", required=false) String logout, Model model ) {
    	
    	
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        
        return "index.jsp";
        
    }
    
   
    
    
    
    
	
}
