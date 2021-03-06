package service;

import entity.Category;
import junit.framework.TestCase;

import java.util.List;

public class CategoryServiceTest extends TestCase {
    CategoryService categoryService = new CategoryService();
    public void testSelectAll() {
        List<Category> list = categoryService.selectAll();
        for(Category c : list) {
            System.out.println(c.getName());
        }
    }
}