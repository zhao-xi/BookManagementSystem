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
}
