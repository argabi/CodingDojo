package com.argabi.taskmanager.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.argabi.taskmanager.models.Task;

@Repository
public interface TaskRepository extends CrudRepository <Task,Long>  , PagingAndSortingRepository<Task,Long> {
	List<Task> findAll();
	
	// oder  A to Z
	List<Task> findByOrderByPriorityAsc();
	
	// oder  Z to A
	List<Task> findByOrderByPriorityDesc();
	
}
