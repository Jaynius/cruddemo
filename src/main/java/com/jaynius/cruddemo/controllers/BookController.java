package com.jaynius.cruddemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jaynius.cruddemo.model.Book;
import com.jaynius.cruddemo.service.IBookService;

@RestController
public class BookController {
	
	@Autowired
	private IBookService service;
	
//	

	public BookController(IBookService service) {
		super();
		this.service = service;
	}



	@GetMapping(path="/books")
	public ResponseEntity<List<Book>> getBooks() {
		return service.getAllBooks();
	}
	
	@GetMapping(path="/helo")
	public String helloWorld() {
		
		return service.helloworld();
	}
	
	@GetMapping(path="/books/book/{id}")
	public ResponseEntity<Book> findById(@PathVariable Long id){
		return service.findById(id);
	}
	
	@PostMapping(path="/addbook")
	public ResponseEntity<Book> addBook(@RequestBody Book book){
		return service.addBook(book);
	}
	
	@DeleteMapping(path="deletebook/{id}")
	public ResponseEntity<Book> deleteById(@PathVariable long id){
		return service.deleteById(id);
	
		
	}
	
}
