package form;

import java.io.Serializable;


public class bookSearchForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bookName;
	private String author;
	private int price;
	private int id;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
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
	
}
