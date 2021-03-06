package service;

import entity.Book;
import junit.framework.TestCase;

import java.util.Date;
import java.util.List;

public class BookServiceTest extends TestCase {
    BookService bookService = new BookService();
    public void testSelectAll() {
        List<Book> list = bookService.selectAll();
        for(Book b : list) {
            System.out.println(b.getName());
        }
    }
    public void testSelectById() {
        Book book = bookService.selectById(1L);
        System.out.println(book.getName());
    }
    public void testSelectByCategoryId() {
        List<Book> list = bookService.selectByCategoryId(1L);
        for(Book b : list) {
            System.out.println(b.getName());
        }
    }
    public void testInsert() {
        Book book = new Book();
        book.setName("测试添加书籍");
        book.setCategoryId(2L);
        book.setImgPath("img\\Java.jpg");
        book.setLevel(2);
        book.setPrice(100);
        book.setCreateTime(new Date());
        bookService.insert(book);
    }
}