package controller;

import entity.Category;
import service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "AddCategoryServlet", urlPatterns = "/category/add.do")
public class AddCategoryServlet extends HttpServlet {
    CategoryService categoryService = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryName = request.getParameter("name");
        Category category = new Category(categoryName);
        categoryService.insert(category);
        response.sendRedirect("/management?target=category");
    }
}
