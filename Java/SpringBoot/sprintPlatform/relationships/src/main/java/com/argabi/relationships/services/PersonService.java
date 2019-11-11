package com.argabi.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.argabi.relationships.models.Person;
import com.argabi.relationships.repositories.PersonRepository;

@Service
public class PersonService {

	// adding the book repository as a dependency
    private final PersonRepository person_Repository; //BookRepository interface 
    
    public PersonService(PersonRepository person_Repository) {
        this.person_Repository = person_Repository;
    }
    
    // returns all the Persons
    public List<Person> allPersons() {
        return  person_Repository.findAll();
    }
    
    // creates a Person
    public Person createBook(Person thePerson) {
        return person_Repository.save(thePerson); // create
    }
   
    
}
