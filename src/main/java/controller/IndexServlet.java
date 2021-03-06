package controller;

import entity.Book;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    BookService bookService = new BookService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.toIndexPage(request, response);
    }

    private void toIndexPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Book> books = bookService.selectAll();
        request.setAttribute("books", books);
        request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
    }
}
