package com.service;

import java.util.List;

import com.entity.Book;

public interface BookService {
	
	public List<Book> getAllBook();
	public List<Book> selectInfoByName(String bookName); 
	public List<Book> selectInfoById(int id); 
	public boolean deleteBookByPrimaryKey(int id);
}
