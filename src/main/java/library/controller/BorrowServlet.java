package library.controller;

import library.model.Book;
import library.model.Card;
import service.bookService.BookService;
import service.cardService.CardService;
import service.studentService.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BorrowServlet", value = "/borrows")
public class BorrowServlet extends HttpServlet {
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
            case "returnBook":
                returnBookForm(request,response);
            case"search":
                searchByName(request,response);
            default:
                showBorrow(request, response);
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("search");
        List<Card>cardList=cardService.searchByName(name);
        request.setAttribute("cardList",cardList);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("book/borrowList.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void returnBookForm(HttpServletRequest request, HttpServletResponse response) {
        int idCard=Integer.parseInt(request.getParameter("id"));
        Card card=cardService.findById(idCard);
        request.setAttribute("card",card);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("book/returnBook.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showBorrow(HttpServletRequest request, HttpServletResponse response) {
        List<Card> cardList=cardService.findAllCard();
        request.setAttribute("cardList",cardList);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("book/borrowList.jsp");
        try {
            requestDispatcher.forward(request,response);
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
            case "returnBook":
                returnBook(request,response);
            default:
        }
    }

    private void returnBook(HttpServletRequest request, HttpServletResponse response) {
        int idCard=Integer.parseInt(request.getParameter("id"));
        String bookName=request.getParameter("nameBook");
        Book book=bookService.findByName(bookName);
        bookService.returnBook(book.getId());
        cardService.update(idCard);
        try {
            response.sendRedirect("/borrows");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
