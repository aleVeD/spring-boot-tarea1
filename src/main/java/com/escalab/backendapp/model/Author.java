package com.escalab.backendapp.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAuthor;
	
    @Column(name = "name", length = 30, nullable = false)
	private String name;

	@Column(name="last_name", length = 20, nullable = false)
	private String lastName;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="author_book",
			   joinColumns=@JoinColumn(name="id_author",
					                   referencedColumnName="idAuthor"),
			   inverseJoinColumns=@JoinColumn(name="id_book",
			                                  referencedColumnName="idBook")	
	           )
	private List<Book> books;


	public Integer getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(Integer idAuthor) {
		this.idAuthor = idAuthor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
