package com.escalab.backendapp.model;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idBook;
	
	@Column(name = "title", length = 300, nullable = false)
	private String title;
	
	@Column(name = "pages", length = 5, nullable = true)
	private int pages;
	
	

	public Book() {
		super();
	}

	public Integer getIdBook() {
		return idBook;
	}

	public void setIdBook(Integer idBook) {
		this.idBook = idBook;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public Book(Integer idBook, String title, int pages) {
		super();
		this.idBook = idBook;
		this.title = title;
		this.pages = pages;
	}
	
}
