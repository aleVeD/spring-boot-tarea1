package com.escalab.backendapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escalab.backendapp.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
