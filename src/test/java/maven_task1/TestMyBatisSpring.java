package maven_task1;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.BookDao;
import com.entity.Book;


public class TestMyBatisSpring {
	@Test
	public void test(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		BookDao bookDao = ctx.getBean(BookDao.class);
		List<Book> books = bookDao.getAllBook();
		for(Book book : books){
			System.out.println(book.getBookName());
		}
		assertNotNull(books);
	}
}
