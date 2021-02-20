package com.hunter.elfnBooks.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hunter.elfnBooks.dto.BookDTO;
import com.hunter.elfnBooks.elastic.entities.BookE;
import com.hunter.elfnBooks.entities.Book;
import com.hunter.elfnBooks.entities.els.repository.BookRepositoryE;
import com.hunter.elfnBooks.entities.repository.BookRepository;
@Service
@Qualifier("ElasticBookServiceImpl")

public class BookServiceImplE implements BookService {
	@Autowired
	BookRepositoryE bookRepositoryE;
	@Override
	public List<BookDTO> all() {
				
		Iterable<BookE> bookList = bookRepositoryE.findAll();
		
		List<BookDTO> bookListDTO = new ArrayList<>();
		bookList.forEach(b -> { 
			BookDTO bdto = new BookDTO();
			bdto.setBookID(b.getBookID());
			bdto.setTitle(b.getTitle());
			bdto.setAuthor(b.getAuthor());
			bdto.setAverage_rating(b.getAverage_rating());
			bdto.setIsbn(b.getIsbn());
			bdto.setIsbn13(b.getIsbn13());
			bdto.setLanguage_code(b.getLanguage_code());
			bdto.setNum_pages(b.getNum_pages());
			bdto.setRatings_count(b.getRatings_count());
			bdto.setText_reviews_count(b.getText_reviews_count());
			bdto.setPublication_date(b.getPublication_date());
			bdto.setPublisher(b.getPublisher());
			bookListDTO.add(bdto);
		});
		
		return bookListDTO;
		
	}

	@Override
	public BookDTO findByBookID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookDTO findByBookISBN(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDTO> findByBookAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delByBookID(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNewBook(BookDTO newBook) {
		// TODO Auto-generated method stub

	}

	@Override
	public void replaceByBookID(BookDTO newBook, int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BookDTO> getByBookTitle(String searchTitle) {
		// TODO Auto-generated method stub
		return null;
	}

}
