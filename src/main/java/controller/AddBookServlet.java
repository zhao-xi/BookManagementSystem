package controller;

import entity.Book;
import entity.Category;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.BookService;
import service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "AddBookServlet", urlPatterns = "/book/add.do")
public class AddBookServlet extends HttpServlet {
    private BookService bookService = new BookService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sf = new ServletFileUpload(factory);
        try {
            List<FileItem> formData = sf.parseRequest(request);
            Book book = new Book();
            for(FileItem fi : formData) {
                if(fi.isFormField()) {
                    switch (fi.getFieldName()) {
                        case "name": book.setName(fi.getString("UTF-8")); break;
                        case "categoryId": book.setCategoryId(Long.parseLong(fi.getString("UTF-8"))); break;
                        case "level": book.setLevel(Integer.parseInt(fi.getString("UTF-8"))); break;
                        case "price": book.setPrice(Integer.parseInt(fi.getString("UTF-8"))); break;
                    }
                } else {
                    // 文件上传项
                    String path = request.getServletContext().getRealPath("/upload");
                    String fileName = UUID.randomUUID().toString();
                    String suffix = fi.getName().substring(fi.getName().lastIndexOf("."));
                    fi.write(new File(path, fileName + suffix));
                    book.setImgPath("/upload/" + fileName + suffix);
                }
            }
            book.setCreateTime(new Date());
            bookService.insert(book);
            response.sendRedirect("/management?target=book");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
