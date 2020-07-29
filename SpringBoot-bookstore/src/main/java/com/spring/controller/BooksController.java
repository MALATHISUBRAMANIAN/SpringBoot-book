package com.spring.controller;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.CrudService;
import com.spring.model.Books;
import com.spring.service.BooksService;

//mark class as Controller
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class BooksController {
//autowire the crudService class
	@Autowired
	CrudService crudService;

//creating a get mapping that retrieves all the books detail from the database 
	@GetMapping("/books")
	private List<Books> getAllBooks() {
		return crudService.getAllBooks();
	}

	/**
	 * getBook is used to get the single book details 
	 * @param bookid
	 * @return Books
	 */
	@GetMapping("/book/{bookid}")
	private Books getBook(@PathVariable("bookid") int bookid) {
		System.out.println("getcalled for book" + bookid);
		return crudService.getBook(bookid);
	}
	
	/**
	 * add is used to register a new book details
	 * 
	 * @param books
	 */
	@PostMapping("/add")
	private void insertBook(@RequestBody Books books) {
		crudService.insert(books);
	}

	/**
	 * edit is used to update the current book details
	 * 
	 * @param bookDetail
	 */
	@PostMapping("/edit")
	private void editBook(@RequestBody Books bookDetail) {
		System.out.println("edit called and values : " + bookDetail.getAuthor());
		crudService.update(bookDetail);
	}

	/**
	 * deleteBook is used to delete the current book
	 * 
	 * @param bookid
	 */
	@DeleteMapping("/delete/{bookid}")
	private void deleteBook(@PathVariable("bookid") int bookid) {
		crudService.delete(bookid);
	}

}
