package com.argabi.taskmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.argabi.taskmanager.models.Task;
import com.argabi.taskmanager.repositories.TaskRepository;

@Service

public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public TaskService (TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	
	//create task
	public void addNewTask(Task task) {
		taskRepository.save(task);
	}
	
	//get all tasks
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	
	//get task by ID
	public Task getTaskbyID (Long id) {
		Optional <Task> optionalTask = taskRepository.findById(id);
		
		if(optionalTask.isPresent()) {
            return optionalTask.get();
        } else {
            return null;
        }
	}
	
	//update
	public Task updateTask (Long id ,String task_name, String assignee, Long priority) {
		Optional <Task> optionalTask = taskRepository.findById(id);
		
		if(optionalTask.isPresent()) {
           Task theTask = optionalTask.get();
           
           theTask.setTask_name(task_name);
           theTask.setAssignee(assignee);
           theTask.setPriority(priority);
           
           return taskRepository.save(theTask);
           
		}
		else
		{
            return null;
        }
	}
	
	
	
	//remove task by Id
	public void deleteTaskByID(Long id) {
		taskRepository.deleteById(id);
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	public List<Task> getAllTasks_A_Z() {
		return taskRepository.findByOrderByPriorityAsc();
	}
    
	public List<Task> getAllTasks_Z_A() {
		return taskRepository.findByOrderByPriorityDesc();
	}
   
	
	
	
	
	
}


















