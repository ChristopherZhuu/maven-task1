package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sun.launcher.resources.launcher;

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
	public String getAllBook(Model model) {
		List<Book> books = bookService.getAllBook();
		for (Book book : books) {
			System.out.println(book.getBookName());
		}
		model.addAttribute("books", books);
		return "Book/index";

	}

	@RequestMapping("/modify/{id}")
	public String ModifyBook(@PathVariable("id") int id, BookSearchForm bookSearchForm, Model model){
		Book bookEntity = new Book();
		List<Book> result = bookService.selectInfoById(id);
		bookEntity = result.get(0);
		BeanUtils.copyProperties(bookEntity, bookSearchForm);
		//model.addAttribute("result", bookEntity);
		return "Book/ModifyInput";
	}
	
	@RequestMapping("/Search")
	public String SearchBook(Model model, BookSearchForm bookSearchForm) {
		
		return "Book/SearchBook";
	}

	@RequestMapping("/SearchResult")
	public String SearchResult(BookSearchForm bookSearchForm, Model model) {
		Book bookentity = new Book();
		BeanUtils.copyProperties(bookSearchForm, bookentity);
		List<Book> result = bookService.selectInfoByName(bookentity
				.getBookName());
		if (result.size() == 0 && bookentity.getBookName() != "") {
			return "Book/BookNotFoundError";
		} else if (bookentity.getBookName() == "") {
			List<Book> allBooks = bookService.getAllBook();
			model.addAttribute("selectByNameResult", allBooks);
			return "Book/SearchResult";
		} else {
			model.addAttribute("selectByNameResult", result);
			return "Book/SearchResult";
		}
	}

	@RequestMapping("/test")
	public String Testjsp(Model model){
		return "Book/test";
	}
	
	
	@RequestMapping("/delete/{id}")
	public String DeleteBook(@PathVariable("id") int id, BookSearchForm bookSearchForm, Model model) {
		boolean status = bookService.deleteBookByPrimaryKey(id);
		
		return "Book/SearchBook";
	}

}
