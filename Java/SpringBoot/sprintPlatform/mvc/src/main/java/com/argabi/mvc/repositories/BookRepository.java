package com.argabi.mvc.repositories;

import java.util.List; //////

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.argabi.mvc.models.Book;

@Repository							//book module , PK is Long same type in the Book of ID where is Long
public interface BookRepository extends CrudRepository <Book,Long> {
	//JPA will do this for us 
	
	// this method retrieves all the books from the database
    List<Book> findAll();
    
    // this method finds books with descriptions containing the search string
    List<Book> findByDescriptionContaining(String search);
    
    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);
    
    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
	
}
