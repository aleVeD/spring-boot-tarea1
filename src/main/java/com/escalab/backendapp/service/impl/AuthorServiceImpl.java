package com.escalab.backendapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.backendapp.model.Author;
import com.escalab.backendapp.repo.AuthorRepository;
import com.escalab.backendapp.service.AuthorService;
@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public List<Author> getAll() {
		List<Author> authors = authorRepository.findAll();
		return authors;
	}

	@Override
	public Author save(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public Author findById(Integer id) {
		Optional<Author> author = authorRepository.findById(id);
		if(author.isPresent()) {
			return author.get();
		}else {
			return new Author();
		}
	}

	@Override
	public Author update(Author author) {
		// TODO Auto-generated method stub
		return authorRepository.save(author);
	}

	@Override
	public Boolean delete(Integer id) {
		if(id != null) {
			authorRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
