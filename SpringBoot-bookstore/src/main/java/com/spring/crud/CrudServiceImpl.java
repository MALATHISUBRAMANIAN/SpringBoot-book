package com.spring.crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.spring.model.Books;

@Service
public class CrudServiceImpl implements CrudService  {
	
	String selectAllSql = "SELECT * FROM Books";
	
	String insertSql = "INSERT INTO Books values(?, ?, ?, ?,?)";
	
	String updateSql = "UPDATE Books SET bookName =?, author= ?, year =?, price = ? WHERE bookid =?";
	
	String deleteSql = "DELETE FROM Books where bookId = ?";
	
	String selectBookSql = "SELECT * FROM Books where bookId =";
	
	
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Autowired
	DataSource dataSource;

	@Override
	public List<Books> getAllBooks() {
		List<Books> bookList = jdbctemplate.query(selectAllSql, BeanPropertyRowMapper.newInstance(Books.class));
		return bookList;
	}
	
	@Override
	public Books getBook(int bookId) {
		Books bookDetails = jdbctemplate.query(selectBookSql+bookId, BeanPropertyRowMapper.newInstance(Books.class)).get(0);
		return bookDetails;
	}

	@Override
	public void insert(Books book) {
		jdbctemplate.update(insertSql, book.getBookid(),book.getBookname(), book.getAuthor(), book.getYear(),book.getPrice());
				
	}

	@Override
	public void update(Books bookdetails) {
		jdbctemplate.update(updateSql, bookdetails.getBookname(), bookdetails.getAuthor(), bookdetails.getYear(),bookdetails.getPrice(), bookdetails.getBookid());
		
		
	}

	@Override
	public void delete(int bookId) {
		jdbctemplate.update(deleteSql, bookId);
		
	}

}
