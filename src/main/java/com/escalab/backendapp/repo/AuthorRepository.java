package com.escalab.backendapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escalab.backendapp.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
