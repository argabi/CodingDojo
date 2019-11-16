package com.argabi.taskmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.argabi.taskmanager.models.Task;
import com.argabi.taskmanager.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>  {
	 User findByName(String name); // username  >> name
	 User findByEmail(String email);
	 List<User> findAll();
}
