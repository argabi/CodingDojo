package com.argabi.relationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.argabi.relationships.models.License;

@Repository	
public interface LicensesRepository extends CrudRepository <License,Long> {

}
