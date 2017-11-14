package maven_task1;

import java.util.List;

import com.entity.Book;

public class TestEverything {
	public static void main(String[] args) {
	
		Book book1 = new Book();
		book1.setAuthor("1");
		Book book2 = new Book();
		book2.setAuthor("2");
		List<Book> book = null;
		book.add(book1);
		book.add(book1);
		
	
	}
}
