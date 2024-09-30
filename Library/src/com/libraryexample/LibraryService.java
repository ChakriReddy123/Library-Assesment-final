package com.libraryexample;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LibraryService {
	String libraryName;
    String address;
    List<Book>  books;
	public LibraryService(String libraryName, String address, List<Book> books) {
		super();
		this.libraryName = libraryName;
		this.address = address;
		this.books = books;
	}
    
	public List<Book> getBooks(){
		return books;
	}
	
	public void addBook(Book b) {
		books.add(b);
	}
	
	public void removeBook(int isbn) {
		books.removeIf(e -> e.getBookIsbnNo() ==isbn);
	}

	public float findMaxPrice(String publisherName) {
		Optional<Book> b=books.stream().filter((e)-> e.getPublisher().equals(publisherName)).collect(Collectors.maxBy((b1, b2) -> Float.compare(b1.getPrice(), b2.getPrice())));
		if(b.isPresent()) {
			return b.get().getPrice();
		}
		else {
			return 0.0f;
		}
	}
	
}
