package dao;

import entity.Category;

import java.util.List;

public interface CategoryDao {
    public List<Category> selectAll();
}
