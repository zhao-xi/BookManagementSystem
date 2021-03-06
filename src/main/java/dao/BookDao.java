package dao;

import entity.Book;

import java.util.List;

public interface BookDao {
    public List<Book> selectAll();
    public Book selectById(Long bookId);
    public List<Book> selectByCategoryId(Long categoryId);
    public void insert(Book book);
}
