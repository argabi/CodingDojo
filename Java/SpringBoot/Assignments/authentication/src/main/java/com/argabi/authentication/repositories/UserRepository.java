package com.argabi.authentication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.argabi.authentication.models.User;


@Repository
public interface UserRepository  extends CrudRepository<User, Long>  {
	 User findByEmail(String email);
}
