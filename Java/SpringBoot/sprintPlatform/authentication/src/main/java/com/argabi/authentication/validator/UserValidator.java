package com.argabi.authentication.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.argabi.authentication.models.User;

@Component
public class UserValidator implements Validator { //org.springframework.validation.Validator;

	// 1
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz); // User models
    } 
    
    // 2
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) { // chick the passowrds are same or not 
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }
    
}
