package com.jaynius.cruddemo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.jaynius.cruddemo.model.Book;

@Service
public interface IBookService {
	ResponseEntity<List<Book>> getAllBooks();
	String helloworld();
//	public ResponseEntity<Book> findById(Long id,Book book);
	ResponseEntity<Book> updateById(Long id, Book newBookData);
//	ResponseEntity<Book> findById(Long id, Book book);
//	ResponseEntity<Book> findById(Long id, Book book);
//	
	public ResponseEntity<Book> findById(Long id);
	public ResponseEntity<Book> addBook(Book book);
	public ResponseEntity<Book> deleteById(long id);


}
