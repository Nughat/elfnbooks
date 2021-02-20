package com.hunter.elfnBooks.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hunter.elfnBooks.dto.BookDTO;
import com.hunter.elfnBooks.service.BookService;

@RestController
@RequestMapping("books")

public class ElfnBookController {
	
	@Autowired
	@Qualifier("ElasticBookServiceImpl")
	BookService bookService;
	
	@Autowired
	@Qualifier("dbBookServiceImpl")
	BookService bookService1;
	
	@GetMapping("/all")
	public ResponseEntity<List<BookDTO>> all()
	{
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "http://localhost:3000");
		
		return ResponseEntity.ok().headers(responseHeaders).body(bookService.all());
	}
	
	@GetMapping("/{id}")   //ID
	public ResponseEntity<BookDTO> getByBookID(@PathVariable Integer id)
	{
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "http://localhost:3000");
		return ResponseEntity.ok().headers(responseHeaders).body(bookService.findByBookID(id));
	}
	
	@GetMapping("/title/{searchTitle}")
	public ResponseEntity<List<BookDTO>> getByBookTitle(@PathVariable String searchTitle)
	{
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "http://localhost:3000");
		return ResponseEntity.ok().headers(responseHeaders).body(bookService.getByBookTitle(searchTitle));
	}
	
	@GetMapping("/isbn/{isbn}")
	public ResponseEntity<BookDTO> getByBookISBN(@PathVariable String isbn)
	{
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "http://localhost:3000");
		return ResponseEntity.ok().headers(responseHeaders).body(bookService.findByBookISBN(isbn));
	}
	
	@GetMapping("/author/{author}")
	public ResponseEntity<List<BookDTO>> getByBookAuthor(@PathVariable String author)
	{
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "http://localhost:3000");
		return ResponseEntity.ok().headers(responseHeaders).body(bookService.findByBookAuthor(author));
	}  
	
	@PostMapping("/add")
	public void addNewBook(@RequestBody BookDTO newBook)
	{
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "http://localhost:3000");
		bookService.addNewBook(newBook);
		ResponseEntity.ok().headers(responseHeaders);
		
		/*
		Response response = new Response();
		if(persons.get(p.getId()) != null){
			response.setStatus(false);
			response.setMessage("Person Already Exists");
			return response;
		}
		persons.put(p.getId(), p);
		response.setStatus(true);
		response.setMessage("Person created successfully");
		return response;
		*/
	
	}
	
	@DeleteMapping("/{id}")
	public void deleteBookID(@PathVariable Integer id)
	{
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "http://localhost:3000");
		bookService.delByBookID(id);
		ResponseEntity.ok().headers(responseHeaders);
	} //books/2/delete
	
	
	@PutMapping("/{id}")
	public void replaceBookID(@RequestBody BookDTO newBook, @PathVariable Integer id)
	{
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "http://localhost:3000");
		bookService.replaceByBookID(newBook, id);
		ResponseEntity.ok().headers(responseHeaders);
	}
	
	
	/*BookDTO a = new BookDTO();
	a.setBookID(1);
	a.setTitle("harry");
	a.setAuthor("jk");
	a.setAverage_rating(4.57);
	a.setIsbn(439785960);
	a.setIsbn13(978043970000l);
	a.setLanguage_code("eng");
	a.setNum_pages(652);
	a.setRatings_count(2095690);
	a.setText_reviews_count(27591);
	a.setPublication_date("9/16/06");
	a.setPublisher("Scholastic Inc.");
	
	List<BookDTO> bookList = new ArrayList<>();
	bookList.add(a);
	BookDTO b = new BookDTO();
	b.setBookID(2);
	b.setTitle("potter");
	b.setAuthor("jk");
	b.setAverage_rating(4.49);
	b.setIsbn(439785961);
	b.setIsbn13(978043980000000l);
	b.setLanguage_code("eng");
	b.setNum_pages(870);
	b.setRatings_count(2153167);
	b.setText_reviews_count(29221);
	b.setPublication_date("9/1/04");
	b.setPublisher("Scholastic Inc.");
	bookList.add(b);
	
	return bookList;*/
}
