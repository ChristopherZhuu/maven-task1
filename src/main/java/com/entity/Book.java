package com.entity;

import java.io.Serializable;

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String bookName;
	private String author;
	private int price;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	@Override
	public String toString() {
		return "id:"+getId()+", bookName:"+getBookName()+", author"+getAuthor()+", price"+getPrice();
		//return this.getId()+"\t"+this.getBookName();
	}
	
	
	
}
