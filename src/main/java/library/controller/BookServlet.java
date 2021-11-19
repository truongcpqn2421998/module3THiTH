package library.controller;

import library.model.Book;
import library.model.Card;
import library.model.Student;
import service.bookService.BookService;
import service.cardService.CardService;
import service.studentService.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/books")
public class BookServlet extends HttpServlet {
    BookService bookService=new BookService();
    StudentService studentService=new StudentService();
    CardService cardService=new CardService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                showBorrow(request,response);
            default:
                showBook(request, response);
        }
    }

    private void showBorrow(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("id");
        Book book=bookService.findById(id);
        List<Student> studentList=studentService.findAllStudent();
        request.setAttribute("book",book);
        request.setAttribute("students",studentList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("book/borrow.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showBook(HttpServletRequest request, HttpServletResponse response) {
        List<Book> bookList=bookService.findAllBook();
        request.setAttribute("bookList",bookList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("book/listBook.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                borrowBook(request,response);
            default:

        }
    }

    private void borrowBook(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        String bookID=request.getParameter("id");
        Book book=bookService.findById(bookID);
        String studentId=request.getParameter("student");
        Student student=studentService.findById(studentId);
        bookService.borrowBook(bookID);
        boolean status=false;
        Date borrowBook=Date.valueOf(request.getParameter("borrow"));
        Date returnBook=Date.valueOf(request.getParameter("return"));
        Card card= new Card(book,student,status,borrowBook,returnBook);
        cardService.save(card);
        try {
            response.sendRedirect("/books");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
