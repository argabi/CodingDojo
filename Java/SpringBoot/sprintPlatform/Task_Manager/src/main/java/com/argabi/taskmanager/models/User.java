package com.argabi.taskmanager.models;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
	
	//1 ID
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	//2 Name
	@Size(min = 2,message="Name must be greater than 2 characters")
	private String name;
	
	
	//3 Email
	@Column(unique=true)
	@Email(message="Email must be valid")
    private String email;
	
	
	//4 Password
	@Size(min=8, message="Password must be greater than 8 characters")
    private String password;
    
    
    //5 Password Confirmation
    @Transient
    private String passwordConfirmation;
    
    ///////////////////////////////////////////////////////////////////////
    @OneToMany(mappedBy="creator", fetch = FetchType.LAZY)
    private List<Task> tasks;
    ///////////////////////////////////////////////////////////////////////

    public  User (){
    	
    }
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
    
    
}



























