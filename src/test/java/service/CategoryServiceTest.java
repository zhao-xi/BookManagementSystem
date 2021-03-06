package service;

import entity.Category;
import junit.framework.TestCase;

import java.util.Date;
import java.util.List;

public class CategoryServiceTest extends TestCase {
    CategoryService categoryService = new CategoryService();
    public void testSelectAll() {
        List<Category> list = categoryService.selectAll();
        for(Category c : list) {
            System.out.println(c.getName());
        }
    }
    public void testSelectById() {
        Category category = categoryService.selectById(2L);
        System.out.println(category.getName());
    }
    public void testInsert() {
        Category category = new Category();
        category.setName("新标签");
        category.setCreateTime(new Date());
        categoryService.insert(category);
        System.out.println(category.getId());
    }
}