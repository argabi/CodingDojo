package com.argabi.dojosandninjas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.argabi.dojosandninjas.models.Ninja;

public interface NinjaRepo extends CrudRepository <Ninja, Long>  {

}
