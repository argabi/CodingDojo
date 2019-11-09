package com.argabi.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.argabi.mvc.models.Book;
import com.argabi.mvc.services.BookService;

@Controller
public class BooksController {

private final BookService bookService;
    
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
    
    
    @RequestMapping("")
    public String root() {
    	return "redirect:/books";
    }
    
    /////////////////////////////////////////////////////////
    
    @RequestMapping("/books")
    public String index(Model model) {
    	
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        
        return "/books/index.jsp"; //inside the books folder (WEB-INF)
    }
    
    /////////////////////////////////////////////////////////
    
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }
    
    /////////////////////////////////////////////////////////

    @RequestMapping(value="/books", method=RequestMethod.POST)
    //@Valid then BindingResult for the results check
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
    	
        if (result.hasErrors()) {
            return "/books/new.jsp"; //found error , reload the page
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    //*****************************************************************************************
    
    //Show Book
    //show assignment
    @RequestMapping("/books/{id}")
    public String showBook(@PathVariable("id") Long id, Model model) {
    	
    	 model.addAttribute("book", bookService.findBook(id));
    	 
        return "/books/show.jsp";
    }
    //*****************************************************************************************
    //*****************************************************************************************
    //*****************************************************************************************
    //*****************************************************************************************

//    
//    // still same data , problem 
//    //submit the edit 
//    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
//    public String update(@Valid @ModelAttribute("book") Book theBook, BindingResult result) {
//        
//    	System.out.println(theBook);
//    	
//    	if (result.hasErrors()) {
//            return "/books/edit.jsp"; //found error , reload the page
//            
//        } else { // Long id, String title,String desc, String lang,Integer numOfPages
//            bookService.updateBook(theBook.getId(),theBook.getTitle(),theBook.getDescription(),theBook.getLanguage(),theBook.getNumberOfPages());
//            return "redirect:/books";
//        }
//    }
    //*****************************************************************************************
    //*****************************************************************************************
    //*****************************************************************************************
    //*****************************************************************************************

	  //Edit Book render the page
	  @RequestMapping("/books/{id}/edit")
	  public String edit(@PathVariable("id") Long id, Model model) {
	  	
	      Book book = bookService.findBook(id);
	            model.addAttribute("book", book);
	            
	     return "/books/edit.jsp";
	 }
 
    
	  
	  // **************************************** NOT WOrking  if i use PUT /DELETE
	  
    //Edit Book render the page
    @RequestMapping(value="/books/{id}/ali", method=RequestMethod.POST) //PUT
    public String update(@PathVariable("id") Long id,
    		@RequestParam(value="title") String title,
    		@RequestParam(value="description") String desc,
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="numberOfPages") Integer numOfPages) {
    	
        bookService.updateBook(id, title, desc, lang, numOfPages);
        
        return "redirect:/books";
    }
    
    
    @RequestMapping(value="/books/{id}/delete", method=RequestMethod.POST) //DELETE
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
    
}























