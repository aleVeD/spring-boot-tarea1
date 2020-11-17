package com.escalab.backendapp.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escalab.backendapp.exception.ModelNotFoundException;
import com.escalab.backendapp.model.Book;
import com.escalab.backendapp.service.BookService;


@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public ResponseEntity<List<Book>> getBooks(){
		List<Book> books = bookService.getAll();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") Integer id){
		if(id != null && id > 0) {
			Book book = bookService.findById(id);
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		}else{
			return new ResponseEntity<Book>(new Book(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Book> saveBook(@Validated @RequestBody Book book){
		Book bookSaved = bookService.save(book);
		return new ResponseEntity<Book>(bookSaved,  HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Book> updateBook(@Validated @RequestBody Book book){
		Book bookUpdated = bookService.update(book);
		return new ResponseEntity<Book>(bookUpdated, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id){
		Book book = bookService.findById(id);
		if(book.getIdBook() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
		}else {
			bookService.delete(id);
			return new ResponseEntity<Book>(HttpStatus.OK);
		}
	}
}
