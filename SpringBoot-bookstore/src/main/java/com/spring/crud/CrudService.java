package com.spring.crud;

import java.util.List;

import com.spring.model.Books;


public interface CrudService {
	
	List<Books> getAllBooks();
	
	void insert(Books book);

	void update(Books bookDetail);

	void delete(int bookId);

	Books getBook(int bookId);

}
