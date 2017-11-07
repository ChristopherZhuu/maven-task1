package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.entity.Book;
import com.service.BookService;

@Controller
@RequestMapping("/Book")
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
}
