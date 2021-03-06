package service;

import entity.Book;
import junit.framework.TestCase;

import java.util.List;

public class BookServiceTest extends TestCase {
    BookService bookService = new BookService();
    public void testSelectAll() {
        List<Book> list = bookService.selectAll();
        for(Book b : list) {
            System.out.println(b.getName());
        }
    }
}