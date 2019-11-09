package com.argabi.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.argabi.mvc.models.Book;
import com.argabi.mvc.repositories.BookRepository;

@Service
public class BookService {

	// adding the book repository as a dependency
    private final BookRepository book_Repository; //BookRepository interface 
    
    public BookService(BookRepository bookRepository) {
        this.book_Repository = bookRepository;
    }
    
    // returns all the books
    public List<Book> allBooks() {
        return book_Repository.findAll();
    }
    
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = book_Repository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    // creates a book
    public Book createBook(Book b) {
        return book_Repository.save(b); // create
    }
    
	
    //---------------------------------------------------------------------------------------------------------------------
    // To update a book, you will have to use the setter methods from the domain model and then call the save method.
   
    //    update a book  id, title, desc, lang, numOfPages
    public Book updateBook(Long id, String title,String desc, String lang,Integer numberOfPages) { 
    	
    	Optional<Book> optionalBook = book_Repository.findById(id);
    	
		  if(optionalBook.isPresent()) {
			  Book theBook = optionalBook.get();
			  
			  //update values set values
			  theBook.setTitle(title);
			  theBook.setDescription(desc);
			  theBook.setLanguage(lang);
			  theBook.setNumberOfPages(numberOfPages);
			  
			  return book_Repository.save(theBook);  //update
			  
	        } else {
	            return null;
	        }
    }
    
    //delete a book
    public void deleteBook(Long id) {
    	  book_Repository.deleteById(id);
    }
    
    //---------------------------------------------------------------------------------------------------------------------

    // updateBook deleteBook
	
}

















