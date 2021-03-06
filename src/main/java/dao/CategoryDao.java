package dao;

import entity.Category;

import java.util.List;

public interface CategoryDao {
    public List<Category> selectAll();
    public Category selectById(Long categoryId);
    public void insert(Category category);
}
