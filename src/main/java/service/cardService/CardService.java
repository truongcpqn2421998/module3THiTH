package service.cardService;

import library.config.ConnectionSingleton;
import library.model.Book;
import library.model.Card;
import library.model.Student;
import service.bookService.BookService;
import service.studentService.StudentService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardService implements ICardService {
    Connection connection = ConnectionSingleton.getConnection();
    BookService bookService = new BookService();
    StudentService studentService = new StudentService();

    @Override
    public List<Card> findAllCard() {
        List<Card> cardList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from card where status=false ");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String bookId = rs.getString("bookId");
                Book book = bookService.findById(bookId);
                String studentId = rs.getString("studentId");
                Student student = studentService.findById(studentId);
                boolean status = rs.getBoolean("status");
                Date borrowDay = rs.getDate("borrowDay");
                Date returnDay = rs.getDate("returnDay");
                Card card = new Card(id, book, student, status, borrowDay, returnDay);
                cardList.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardList;
    }

    public List<Card> searchByName(String name){
        List<Card> cardList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from card join student  on student.ID = card.studentId where name like %?  ");
            preparedStatement.setString(1,name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String bookId = rs.getString("bookId");
                Book book = bookService.findById(bookId);
                String studentId = rs.getString("studentId");
                Student student = studentService.findById(studentId);
                boolean status = rs.getBoolean("status");
                Date borrowDay = rs.getDate("borrowDay");
                Date returnDay = rs.getDate("returnDay");
                Card card = new Card(id, book, student, status, borrowDay, returnDay);
                cardList.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardList;
    }

    @Override
    public void save(Card card) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into card(bookId,studentId,status,borrowDay,returnDay) value (?,?,?,?,?)");
            preparedStatement.setString(1, card.getBook().getId());
            preparedStatement.setString(2, card.getStudent().getId());
            preparedStatement.setBoolean(3, card.isStatus());
            preparedStatement.setDate(4, card.getBorrowDay());
            preparedStatement.setDate(5, card.getReturnDay());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Card findById(int id) {
        Card card = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select*from card where id=?;");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String bookId = rs.getString("bookId");
                Book book = bookService.findById(bookId);
                String studentId = rs.getString("studentId");
                Student student = studentService.findById(studentId);
                boolean status = rs.getBoolean("status");
                Date borrowDay = rs.getDate("borrowDay");
                Date returnDay = rs.getDate("returnDay");
                card = new Card(id, book, student, status, borrowDay, returnDay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }

    @Override
    public void update(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update card set status=true where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void remove(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from card where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
