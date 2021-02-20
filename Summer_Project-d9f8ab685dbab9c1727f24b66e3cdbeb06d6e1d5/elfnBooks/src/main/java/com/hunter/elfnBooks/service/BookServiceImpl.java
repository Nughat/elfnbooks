package com.hunter.elfnBooks.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.hunter.elfnBooks.dto.BookDTO;
import com.hunter.elfnBooks.entities.Book;
import com.hunter.elfnBooks.entities.repository.BookRepository;

@Service
@Qualifier("dbBookServiceImpl")

public class BookServiceImpl implements BookService {
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<BookDTO> all() {
		// TODO Auto-generated method stub
		List<Book> bookList = bookRepository.findAll();
		
		List<BookDTO> bookListDTO = new ArrayList<>();
		for(Book b: bookList) 
		{
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
		}
		
		return bookListDTO;
		//return null;
	}
	@Override
	public BookDTO findByBookID(int id) {
		BookDTO bdto = new BookDTO();
		
		Optional<Book> bk = bookRepository.findById(id);
		bk.ifPresent(b -> {
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
		});
		
		return bdto;
	}
	
	public List<BookDTO> getByBookTitle(String searchTitle) {

		List<Book> bookList = bookRepository.findByTitle(searchTitle);
		
		List<BookDTO> bookListDTO = new ArrayList<>();
		
			for(Book b: bookList) 
			{
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
			}
			
			return bookListDTO;
	}
	
	@Override
	public BookDTO findByBookISBN(String isbn) {
		BookDTO bdto = new BookDTO();
		
		Book b = bookRepository.findByISBN(isbn);
		
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
		
		
		return bdto;
		
	}
	
	@Override
	public List<BookDTO> findByBookAuthor(String author)
	{
		List<Book> bookList = bookRepository.findByAuthor(author);
		
		List<BookDTO> bookListDTO = new ArrayList<>();
		
			for(Book b: bookList) 
			{
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
			}
			
			return bookListDTO;
	}

	
	@Override
	public void delByBookID(int id) {
		bookRepository.deleteById(id);
	}
	
	@Override
	public void addNewBook(BookDTO newBook)
	{
		Book bk = new Book();
		
		bk.setBookID(newBook.getBookID());
		bk.setTitle(newBook.getTitle());
		bk.setAuthor(newBook.getAuthor());
		bk.setAverage_rating(newBook.getAverage_rating());
		bk.setIsbn(newBook.getIsbn());
		bk.setIsbn13(newBook.getIsbn13());
		bk.setLanguage_code(newBook.getLanguage_code());
		bk.setNum_pages(newBook.getNum_pages());
		bk.setRatings_count(newBook.getRatings_count());
		bk.setText_reviews_count(newBook.getText_reviews_count());
		bk.setPublication_date(newBook.getPublication_date());
		bk.setPublisher(newBook.getPublisher());
		
		bookRepository.save(bk);

	}
	
	@Override
	public void replaceByBookID(BookDTO newBook, int id)
	{
		/*
	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
		 return repository.findById(id)
	      .map(employee -> {
	        employee.setName(newEmployee.getName());
	        employee.setRole(newEmployee.getRole());
	        return repository.save(employee);
	      })
		 */
		
		Optional<Book> bk = bookRepository.findById(id);
		bk.ifPresent(b -> {
			b.setBookID(newBook.getBookID());
			b.setTitle(newBook.getTitle());
			b.setAuthor(newBook.getAuthor());
			b.setAverage_rating(newBook.getAverage_rating());
			b.setIsbn(newBook.getIsbn());
			b.setIsbn13(newBook.getIsbn13());
			b.setLanguage_code(newBook.getLanguage_code());
			b.setNum_pages(newBook.getNum_pages());
			b.setRatings_count(newBook.getRatings_count());
			b.setText_reviews_count(newBook.getText_reviews_count());
			b.setPublication_date(newBook.getPublication_date());
			b.setPublisher(newBook.getPublisher());
			
			bookRepository.save(b);
		});
		
		
		
	}

}
