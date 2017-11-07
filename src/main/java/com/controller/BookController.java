package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;




import org.springframework.web.bind.annotation.SessionAttributes;

import com.entity.Book;
import com.form.BookSearchForm;
import com.service.BookService;


@Controller
@RequestMapping("/Book")
@SessionAttributes(value = "bookSearchForm")
public class BookController {
	@Resource
	BookService bookService;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(BookController.class);
	@RequestMapping("/getAllBook")
	public String getAllBook(Model model){
		List<Book> books = bookService.getAllBook();
		for(Book book : books){
			System.out.println(book.getBookName());
		}
		model.addAttribute("books",books);
		
		
		return "Book/index";
		
	}
	
/*	@RequestMapping("/Search")
	public String SearchBook(Model model, BookSearchForm bookSearchForm){
		
		return "Book/SearchBook";
	}*/
	
	@RequestMapping("/SearchResult")
	public String SearchResult(BookSearchForm bookSearchForm, Model model){
		Book bookentity = new Book();
		BeanUtils.copyProperties(bookSearchForm, bookentity);
		List<Book> result = bookService.selectInfoByName(bookentity.getBookName());
		model.addAttribute("selectByNameResult", result);
		return "Book/SearchResult";
	}
}
