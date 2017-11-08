package com.service;

import java.util.List;

import com.entity.Book;

public interface BookService {
	
	public List<Book> getAllBook();
	public List<Book> selectInfoByName(String bookName); 

	public boolean deleteBookByPrimaryKey(int id);
}
