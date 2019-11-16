package com.argabi.taskmanager.services;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.argabi.taskmanager.models.User;
import com.argabi.taskmanager.repositories.UserRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
	
	
	private UserRepository userRepository;
    
    public UserDetailsServiceImplementation(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	System.out.println("_______________________________");
    	System.out.println(email);
    	System.out.println("_______________________________");
    	
    	// String email =  email ;
        User user = userRepository.findByEmail(email); //findByUsername
        
        if(user == null) {
        	System.out.println("User not found");
        	
            throw new UsernameNotFoundException("User not found");
        }
        
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthorities(user));
    }
    
 // 2
    private List<GrantedAuthority> getAuthorities(User user){
    	
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
        authorities.add(grantedAuthority);
        
        return authorities;
    }
    
    
}
