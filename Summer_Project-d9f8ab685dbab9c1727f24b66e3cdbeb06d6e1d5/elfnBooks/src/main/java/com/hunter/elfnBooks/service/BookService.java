package com.hunter.elfnBooks.service;

import java.util.List;

import com.hunter.elfnBooks.dto.BookDTO;

public interface BookService {
	List<BookDTO> all();
	BookDTO findByBookID(int id);
	BookDTO findByBookISBN(String isbn);
	List<BookDTO> findByBookAuthor(String author);
	void delByBookID(int id);
	void addNewBook(BookDTO newBook);
	void replaceByBookID(BookDTO newBook, int id);
	List<BookDTO> getByBookTitle(String searchTitle);
	
}
