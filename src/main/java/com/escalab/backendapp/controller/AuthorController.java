package com.escalab.backendapp.controller;

import java.util.List;

import com.escalab.backendapp.exception.ModelNotFoundException;
import com.escalab.backendapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.escalab.backendapp.model.Author;
import com.escalab.backendapp.service.AuthorService;

@RestController
@RequestMapping("authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping
	public ResponseEntity<List<Author>> getAuthors(){
		List<Author> authors = authorService.getAll();
		return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Author> getAuthor(@PathVariable("id") Integer id){
		if(id != null && id > 0) {
			Author author = authorService.findById(id);
			return new ResponseEntity<Author>(author, HttpStatus.OK);
		}else{
			return new ResponseEntity<Author>(new Author(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Author> saveBook(@Validated @RequestBody Author author){
		Author authorSaved = authorService.save(author);
		return new ResponseEntity<Author>(authorSaved,  HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<Author> updateBook(@Validated @RequestBody Author author){
		Author authorUpdated = authorService.update(author);
		return new ResponseEntity<Author>(authorUpdated,  HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id){
		Author author = authorService.findById(id);
		if(author.getIdAuthor() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
		}else {
			authorService.delete(id);
			return new ResponseEntity<Book>(HttpStatus.OK);
		}
	}
}
