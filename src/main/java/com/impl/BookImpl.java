package com.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BookDao;
import com.entity.Book;
import com.service.BookService;

@Service
public class BookImpl implements BookService{
	
	@Resource
	BookDao bookDao;
	public List<Book> getAllBook() {
		
		return bookDao.getAllBook();
	}
	
}
