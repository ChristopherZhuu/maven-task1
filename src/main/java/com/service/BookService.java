package com.service;

import java.util.List;

import com.entity.Book;

public interface BookService {
	
	public List<Book> getAllBook();
	public List<Book> selectInfoByName(String bookName); 
	public List<Book> selectInfoById(int id); 
	public boolean deleteBookByPrimaryKey(int id);
	public void updateBook(Book book);
	public void insertBook(Book book);
	public List<Book> selectInfoByPage(String bookName, int page);
}
