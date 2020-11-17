package com.escalab.backendapp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.backendapp.model.Book;
import com.escalab.backendapp.repo.BookRepository;
import com.escalab.backendapp.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepo;

	@Override
	public List<Book> getAll() {
		List<Book> books = bookRepo.findAll();
		books.forEach((book)->{
			System.out.println(book);
		});
		return books;
	}

	@Override
	public Book save(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public Book findById(Integer id) {
		Optional<Book> book = bookRepo.findById(id);
		if(book.isPresent()) {
			return book.get();
		}else {
			return new Book();
		}
	}

	@Override
	public Book update(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public Boolean delete(Integer id) {
		if(id != null) {
			bookRepo.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

}
