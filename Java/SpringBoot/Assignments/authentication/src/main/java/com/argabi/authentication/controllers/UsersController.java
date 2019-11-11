package com.argabi.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.argabi.authentication.models.User;
import com.argabi.authentication.services.UserService;
import com.argabi.authentication.validator.UserValidator;

@Controller
public class UsersController {
	
	private final UserService userService;
    private final UserValidator userValidator; // for confirming passowrd , are same or not 
	
    public UsersController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	
    	// for validat passowrd , are same or not 
    	userValidator.validate(user,result); 
        
    	if(result.hasErrors())
    	{
    		 return "registrationPage.jsp";
    	}
    	User u = userService.registerUser(user);
    	session.setAttribute("userId", u.getId());
    	return"redirect:/home";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    	boolean isAuthenticated = userService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User u = userService.findByEmail(email);
    		session.setAttribute("userId", u.getId());
    		return"redirect:/home";
    	}
    	else {
			model.addAttribute("error", "Invalid Credentials. Please try again.");
			return "loginPage.jsp";
		}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	Long userId = (Long) session.getAttribute("userId");  // opject >> long
    	User u = userService.findUserById(userId);
    	model.addAttribute("user",u);
    	return "homePage.jsp";
    	
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    	session.invalidate();
    	return "redirect:/login";
    }
    
}






























