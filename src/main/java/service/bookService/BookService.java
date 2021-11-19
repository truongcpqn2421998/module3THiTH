package service.bookService;

import library.config.ConnectionSingleton;
import library.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService {
    Connection connection= ConnectionSingleton.getConnection();
    @Override
    public List<Book> findAllBook() {
        List<Book> bookList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select *from book");
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                String id=rs.getString("id");
                String name=rs.getString("name");
                String author=rs.getString("author");
                String description=rs.getString("description");
                int quantity=rs.getInt("quantity");
                Book book=new Book(id,name,author,description,quantity);
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public Book findByName(String nameBook){
        Book book=null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select*from book where name=?;");
            preparedStatement.setString(1,nameBook);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                String id=rs.getString("id");
                String author=rs.getString("author");
                String description=rs.getString("description");
                int quantity=rs.getInt("quantity");
                book=new Book(id,nameBook,author,description,quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
    @Override
    public Book findById(String id) {
        Book book=null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select*from book where id=?;");
            preparedStatement.setString(1,id);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                String name=rs.getString("name");
                String author=rs.getString("author");
                String description=rs.getString("description");
                int quantity=rs.getInt("quantity");
                book=new Book(id,name,author,description,quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public void borrowBook(String id) {
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("update book set quantity=quantity-1 where id=?;");
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void returnBook(String id) {
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("update book set quantity=quantity+1 where id=?");
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
