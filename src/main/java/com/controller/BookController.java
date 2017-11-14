package com.controller;

import java.util.ArrayList;
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

import com.dao.BookDao;
import com.entity.Book;
import com.entity.Page;
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
		model.addAttribute("books", books);
		return "Book/index";

	}

	@RequestMapping("/insert")
	public String InsertBook(Model model) {
		return "Book/BookInsert";
	}

	@RequestMapping("/InsertConfirm")
	public String InsertConfirm(BookSearchForm bookSearchForm, Model model) {
		Book book = new Book();
		BeanUtils.copyProperties(bookSearchForm, book);
		bookService.insertBook(book);
		return "Book/SearchBook";
	}

	@RequestMapping("/ModifyComfirm")
	public String ModifyComfirm(BookSearchForm bookSearchForm, Model model) {
		Book book = new Book();
		BeanUtils.copyProperties(bookSearchForm, book);
		bookService.updateBook(book);
		return "Book/SearchBook";
	}

	@RequestMapping("/modify/{id}")
	public String ModifyBook(@PathVariable("id") int id,
			BookSearchForm bookSearchForm, Model model) {
		Book bookEntity = new Book();
		List<Book> result = bookService.selectInfoById(id);
		bookEntity = result.get(0);
		BeanUtils.copyProperties(bookEntity, bookSearchForm);
		return "Book/ModifyInput";
	}

	@RequestMapping("/Search")
	public String SearchBook(Model model, BookSearchForm bookSearchForm) {

		return "Book/SearchBook";
	}

	@RequestMapping("/SearchResult")
	public String SearchResult(BookSearchForm bookSearchForm, Model model) {
		Book bookentity = new Book();
		int dist = 5;
		int pageCnt;
		int curPage;
		BeanUtils.copyProperties(bookSearchForm, bookentity);
		//List<Book> result = bookService.selectInfoByName(bookentity
			//	.getBookName());
		List<Book> result = bookService.selectInfoByPage(bookentity.getBookName(),1);
		List<Book> resultAll = bookService.getAllBook();
		int size = resultAll.size();
		if(resultAll.size()%dist==0){
			pageCnt = resultAll.size()/dist;
		}else{
			pageCnt = resultAll.size()/dist+1;
		}
		List<Page> pages = new ArrayList<Page>();
		for(int i=0;i<pageCnt;i++){
			pages.add(new Page(i+1));
		}
		curPage = bookSearchForm.getPageIndex();
		if(curPage==0){
			curPage = 1;
			result = bookService.selectInfoByPage(bookentity.getBookName(), curPage);
		}else{
			result = bookService.selectInfoByPage(bookentity.getBookName(), curPage);
		}

		
		int pageIndex = bookSearchForm.getPageIndex();
		model.addAttribute("selectByNameResult", result);
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("pages", pages);
		model.addAttribute("pageIndex", pageIndex);
		return "Book/SearchResult";
	/*	if (result.size() == 0 && bookentity.getBookName() != "") {
			return "Book/BookNotFoundError";
		} else if (bookentity.getBookName() == "") {
			//List<Book> allBooks = bookService.getAllBook();
			List<Book> result = bookService.selectInfoByPage(bookentity.getBookName(), 1);
			model.addAttribute("selectByNameResult", result);
			return "Book/SearchResult";
		} else {
			model.addAttribute("selectByNameResult", result);
			
			
			return "Book/SearchResult";
		}*/
	}

	@RequestMapping("/SearchResult/{page}")
	public String SearchPage(BookSearchForm bookSearchForm, @PathVariable("page") int page, Model model){
		Book bookEntity = new Book();
		int dist = 5;
		int curPage;
		int pageCnt=3;
		BeanUtils.copyProperties(bookSearchForm, bookEntity);
		List<Book> result = bookService.selectInfoByPage(bookEntity.getBookName(), page);
		List<Book> resultAll = bookService.getAllBook();
		
		if(resultAll.size()%dist==0){
			pageCnt = resultAll.size()/dist;
		}else{
			pageCnt = resultAll.size()/dist+1;
		}
		List<Page> pages = new ArrayList<Page>();
		for(int i=0;i<pageCnt;i++){
			pages.add(new Page(i+1));
		}
		curPage=page;
		model.addAttribute("selectByNameResult", result);
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("pages", pages);
		model.addAttribute("curPage", curPage);
		return "Book/SearchResult";
	}
	
	@RequestMapping("/test")
	public String Testjsp(Model model) {
		return "Book/test";
	}

	@RequestMapping("/delete/{id}")
	public String DeleteBook(@PathVariable("id") int id,
			BookSearchForm bookSearchForm, Model model) {
		boolean status = bookService.deleteBookByPrimaryKey(id);

		return "Book/SearchBook";
	}

}
