package com.hunter.elfnBooks.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Books")

public class Book {
	@Id
	@Column(name = "bookID")
	private int bookID;
	@Column(name = "title")
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "average_rating")
	private double average_rating;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "isbn13")
	private String isbn13;
	
	@Column(name = "language_code")
	private String language_code;
	
	@Column(name = "num_pages")
	private int num_pages;
	
	@Column(name = "ratings_count")
	private int ratings_count;
	
	@Column(name = "text_reviews_count")
	private int text_reviews_count;
	
	@Column(name = "publication_date")
	private String publication_date;
	
	@Column(name = "publisher")
	private String publisher;
	
	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getAverage_rating() {
		return average_rating;
	}

	public void setAverage_rating(double average_rating) {
		this.average_rating = average_rating;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public String getLanguage_code() {
		return language_code;
	}

	public void setLanguage_code(String language_code) {
		this.language_code = language_code;
	}

	public int getNum_pages() {
		return num_pages;
	}

	public void setNum_pages(int num_pages) {
		this.num_pages = num_pages;
	}

	public int getRatings_count() {
		return ratings_count;
	}

	public void setRatings_count(int ratings_count) {
		this.ratings_count = ratings_count;
	}

	public int getText_reviews_count() {
		return text_reviews_count;
	}

	public void setText_reviews_count(int text_reviews_count) {
		this.text_reviews_count = text_reviews_count;
	}

	public String getPublication_date() {
		return publication_date;
	}

	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
