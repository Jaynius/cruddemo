package com.jaynius.cruddemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jaynius.cruddemo.model.Book;
import com.jaynius.cruddemo.repositories.BookRepo;

@Component
public class BookServiceImpl implements IBookService{
	 private  BookRepo bookRepository;
	 
	 public  BookServiceImpl(BookRepo bookRepository) {
		 this.bookRepository=bookRepository;
		 
	 }

	 public ResponseEntity<Book> addBook(Book book){
		 Book savedBook=bookRepository.save(book);
		 return new ResponseEntity<>(savedBook,HttpStatus.CREATED);
		 
	 }


	@Override
	public ResponseEntity<List<Book>> getAllBooks() {
		try {
			List<Book> bookList=new ArrayList<>();
			bookRepository.findAll().forEach(bookList::add);
			if(bookList.isEmpty()) {
				return new ResponseEntity<>(bookList,HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception ex) {
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}



	@Override
	public String helloworld() {
		// TODO Auto-generated method stub
		return "hello world";
	}
	
	



	@Override
	public ResponseEntity<Book> updateById(Long id, Book newBookData) {
		Optional<Book> oldBookData=bookRepository.findById(id);
		
		if(oldBookData.isPresent()) {
			Book updatedBookData=oldBookData.get();
			updatedBookData.setTitle(newBookData.getTitle());
			updatedBookData.setAuthor(newBookData.getAuthor());
			
			Book bookObj=bookRepository.save(updatedBookData);
			
			return new ResponseEntity<>(bookObj,HttpStatus.OK);
			
		}
	
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
	}



	@SuppressWarnings("deprecation")
	@Override
	public ResponseEntity<Book> findById(Long id) {
		Book book=bookRepository.getById(id);
		if(book!=null) {
			return new ResponseEntity<>(book,HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		

	}

	@Override
	public ResponseEntity<Book> deleteById(long id) {

		bookRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
