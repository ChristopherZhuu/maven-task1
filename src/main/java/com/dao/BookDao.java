package com.dao;

import java.util.List;

import com.entity.Book;

public interface BookDao {
	public List<Book> getAllBook(); 
	public List<Book> selectInfoByName(String bookNameString); 
	public boolean deleteBookByPrimaryKey(int id);
	
	public List<Book> selectInfoById(int id);
	
	public void updateBook(Book book);
}
