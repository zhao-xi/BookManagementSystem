package dao;

import entity.Book;

import java.util.List;

public interface BookDao {
    public List<Book> selectAll();
}
