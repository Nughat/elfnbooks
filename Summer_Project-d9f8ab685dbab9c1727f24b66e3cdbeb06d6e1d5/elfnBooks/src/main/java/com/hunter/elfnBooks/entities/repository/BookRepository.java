package com.hunter.elfnBooks.entities.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hunter.elfnBooks.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
	@Query("SELECT b FROM Book b where b.title like ?1%")
	public List<Book> findByTitle(String title);
	
	@Query("SELECT b FROM Book b where b.isbn = :isbn") 
	public Book findByISBN(String isbn);	
	
	@Query("SELECT b FROM Book b where b.author like ?1%")
	public List<Book> findByAuthor(String author);
}
