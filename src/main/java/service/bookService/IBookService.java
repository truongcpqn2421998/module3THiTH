package service.bookService;

import library.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAllBook();

    Book findById(String id);

    void borrowBook(String id);

    void returnBook(String id);
}
