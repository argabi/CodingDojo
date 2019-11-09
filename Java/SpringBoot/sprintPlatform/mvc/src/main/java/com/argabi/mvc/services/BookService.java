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
    
    // creates a book
    public Book createBook(Book b) {
        return book_Repository.save(b);
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
	
	
}
