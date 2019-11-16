package com.argabi.taskmanager.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.argabi.taskmanager.models.Task;
import com.argabi.taskmanager.services.TaskService;
import com.argabi.taskmanager.services.UserService;

@Controller
public class TaskController {

	private UserService userService;
	private TaskService taskService;

	    public TaskController(UserService userService, TaskService taskService) {
	        this.userService = userService; 
	        this.taskService = taskService;
	    }
	    
    //----------------------------------------------------------------------------------------------------------------\\

	//After login 
    @RequestMapping("/tasks")
    public String home(Principal principal, Model model) {
    	String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
        model.addAttribute("tasks",taskService.getAllTasks() );
        return "homePage.jsp";
    }
    
    //Priority High to Low
    @RequestMapping("/tasks/HightoLow")
    public String HightoLow(Principal principal, Model model) {
    	String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
        model.addAttribute("tasks",taskService.getAllTasks_A_Z() );
        return "homePage.jsp";
    }
	
    //Priority Low to High
    @RequestMapping("/tasks/LowtoHigh")
    public String LowtoHigh(Principal principal, Model model) {
    	String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
        model.addAttribute("tasks",taskService.getAllTasks_Z_A() );
        return "homePage.jsp";
    }
    
    //----------------------------------------------------------------------------------------------------------------\\
    
    //newTaskPage rendring page
    @RequestMapping("/tasks/new")
    public String newtaskPage(Model model,HttpSession session,Principal principal) {
    	String email = principal.getName();
    	model.addAttribute("currentUser", userService.findByEmail(email));
    	model.addAttribute("assignees", userService.getAllUsers());
        return "newTask.jsp";
    }
    
    //Create Task - CRUD
    //post
    @PostMapping("/tasks/new")
    public String createNewTask(@Valid @ModelAttribute("task") Task task, BindingResult result, Model model) {
    	
    	if (result.hasErrors()) {
    		System.out.println("error in creating a new task");
            return "newTask.jsp";
        }
    	
        taskService.addNewTask(task);
        System.out.println("created task  done");
        return "redirect:/tasks";
    }
    
    //----------------------------------------------------------------------------------------------------------------\\
    
    //view Task 
    @RequestMapping("/tasks/{id}")
    public String viewTaskPage(@PathVariable("id") Long id,Model model,Principal principal) {
    	String email = principal.getName();
    	//loged in User ID
    	model.addAttribute("currentUserID", userService.findByEmail(email).getId());
    	model.addAttribute("currentUserName", userService.findByEmail(email).getName());
    	model.addAttribute("theTaskInfo", taskService.getTaskbyID(id)); 
      
    	return "ViewTaskPage.jsp";
    }
    
    //----------------------------------------------------------------------------------------------------------------\\

    //delete Task - CRUD
    @PostMapping("/tasks/{id}/delete")
    public String deleteTask(@PathVariable("id") Long id,Model model,Principal principal) {
    	
    	taskService.deleteTaskByID(id);
    	System.out.println(" task has been deleted/completed  done");
    	
    	return "redirect:/tasks";
    }
    
    //----------------------------------------------------------------------------------------------------------------\\
    
  //view Task for Editing
    @RequestMapping("/tasks/{id}/edit")
    public String editTaskPage(@PathVariable("id") Long id,Model model,Principal principal) {
    	
    	//only the creatoer can access this page or redirect to /tasks
    	String email = principal.getName();
    	Task theSelectedTask = taskService.getTaskbyID(id);
  
    	if(userService.findByEmail(email).getName() != theSelectedTask.getCreator().getName()) {
    		return "redirect:/tasks";
    	}
    	
    	
    	model.addAttribute("assignees", userService.getAllUsers());
    	
    	model.addAttribute("theTaskInfo", theSelectedTask); 
      
    	return "editPage.jsp";
    }
    
    //----------------------------------------------------------------------------------------------------------------\\
    
    //Updating - CRUD
    
    @PostMapping(value="/tasks/{id}/edit") 
    public String updating(@PathVariable("id") Long id,
    		
    		@RequestParam(value="task_name") String task_name,
    		@RequestParam(value="assignee") String assignee,
    		@RequestParam(value="priority") Long priority) {
    	
    	taskService.updateTask(id, task_name, assignee, priority);
    	
    	System.out.println(" task has been updated  done");
    	
        return "redirect:/tasks";
    }
    
    
    
}

























