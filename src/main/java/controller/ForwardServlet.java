package controller;

import entity.Category;
import service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ForwardServlet", urlPatterns = "/page/*")
public class ForwardServlet extends HttpServlet {
    private CategoryService categoryService = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println("uri: " + uri);
        String subUri = uri.substring(uri.lastIndexOf("/") + 1);
        System.out.println("subUri: " + subUri);
        if(subUri.equals("add_book")) {
            List<Category> categories = categoryService.selectAll();
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/WEB-INF/jsp/add_book.jsp").forward(request, response);
        } else if(subUri.equals("add_category")) {
            request.getRequestDispatcher("/WEB-INF/jsp/add_category.jsp").forward(request, response);
        }
    }
}
