package service;

import dao.BookDao;
import entity.Book;
import utils.MybatisUtils;

import java.util.List;

public class BookService {
    public List<Book> selectAll() {
        return (List<Book>) MybatisUtils.executeQuery(sqlSession -> {
            BookDao bookDao = sqlSession.getMapper(BookDao.class);
            List<Book> list = bookDao.selectAll();
            return list;
        });
    }
    public Book selectById(Long bookId) {
        return (Book) MybatisUtils.executeQuery(sqlSession -> {
            BookDao bookDao = sqlSession.getMapper(BookDao.class);
            Book book = bookDao.selectById(bookId);
            return book;
        });
    }
    public List<Book> selectByCategoryId(Long categoryId) {
        return (List<Book>) MybatisUtils.executeQuery(sqlSession -> {
            BookDao bookDao = sqlSession.getMapper(BookDao.class);
            List<Book> list = bookDao.selectByCategoryId(categoryId);
            return list;
        });
    }
    public void insert(Book book) {
        MybatisUtils.executeUpdate(sqlSession -> {
            BookDao bookDao = sqlSession.getMapper(BookDao.class);
            bookDao.insert(book);
            return null;
        });
    }
}
