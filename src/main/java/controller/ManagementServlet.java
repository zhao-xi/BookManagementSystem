package controller;

import entity.Book;
import entity.Category;
import service.BookService;
import service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagementServlet", urlPatterns = "/management")
public class ManagementServlet extends HttpServlet {
    private BookService bookService = new BookService();
    private CategoryService categoryService = new CategoryService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String target = request.getParameter("target");
        List<Category> categories = categoryService.selectAll();
        request.setAttribute("categories", categories);
        if(target != null && target.equals("category")) {
            request.getRequestDispatcher("WEB-INF/jsp/category.jsp").forward(request, response);
        } else {
            String category = request.getParameter("category");
            List<Book> books = null;
            if(category != null) {
                books = bookService.selectByCategoryId(Long.parseLong(category));
            } else {
                books = bookService.selectAll();
            }
            request.setAttribute("books", books);
            request.getRequestDispatcher("WEB-INF/jsp/book.jsp").forward(request, response);
        }
    }
}
