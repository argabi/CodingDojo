package com.argabi.mvc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.argabi.mvc.models.Book;
import com.argabi.mvc.services.BookService;

@RestController
public class BooksApi {

	 private final BookService book_Service;
	 
	    public BooksApi(BookService bookService){
	        this.book_Service = bookService;
	    }
	    
	    
	    @RequestMapping("/api/books")
	    public List<Book> index() {
	        return book_Service.allBooks();
	    }
	    
	    @RequestMapping(value="/api/books", method=RequestMethod.POST)
	   
	    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
	        
	    	Book book = new Book(title, desc, lang, numOfPages);
	        return book_Service.createBook(book);
	    }
	    
	    @RequestMapping("/api/books/{id}")
	    public Book show(@PathVariable("id") Long id) {
	        Book book = book_Service.findBook(id);
	        return book;
	    }
	    
}
