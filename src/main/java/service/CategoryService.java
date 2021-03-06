package service;

import dao.CategoryDao;
import entity.Category;
import utils.MybatisUtils;

import java.util.List;

public class CategoryService {
    public List<Category> selectAll() {
        return (List<Category>) MybatisUtils.executeQuery(sqlSession -> {
            CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
            List<Category> list = categoryDao.selectAll();
            return list;
        });
    }
}
