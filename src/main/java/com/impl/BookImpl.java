package com.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BookDao;
import com.entity.Book;
import com.service.BookService;

@Service
public class BookImpl implements BookService {

	@Resource
	BookDao bookDao;

	public List<Book> getAllBook() {

		return bookDao.getAllBook();
	}

	@Override
	public List<Book> selectInfoByName(String bookName) {
		// TODO Auto-generated method stub
		return bookDao.selectInfoByName(bookName);
	}

	@Override
	public boolean deleteBookByPrimaryKey(int id) {
		bookDao.deleteBookByPrimaryKey(id);
		return true;
	}

	@Override
	public List<Book> selectInfoById(int id) {

		return bookDao.selectInfoById(id);
	}

	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);

	}

	@Override
	public void insertBook(Book book) {
		bookDao.insertBook(book);

	}

	@Override
	public List<Book> selectInfoByPage(String bookName, int page) {
		int dist = 5;
		int actualPage;
		List<Book> books = null;
		if (bookName == "") {
			books = bookDao.getAllBook();
		} else {
			books = bookDao.selectInfoByName(bookName);
		}
		if (books.size() % dist == 0) {
			actualPage = books.size() / dist;
		} else {
			actualPage = books.size() / dist + 1;
		}
		List<Book> result = new ArrayList<Book>();
		int initial = (page - 1) * dist;
		if (page != actualPage) {
			for (int i = 0; i < dist; i++) {
				result.add(books.get(initial + i));
			}
		} else if (page == actualPage && books.size() % dist != 0) {
			for (int i = 0; i < books.size() % dist; i++) {
				result.add(books.get(initial + i));
			}
		} else {
			for (int i = 0; i < dist; i++) {
				result.add(books.get(initial + i));
			}
		}

		return result;
	}

}
