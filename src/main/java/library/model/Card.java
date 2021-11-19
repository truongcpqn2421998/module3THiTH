package library.model;

import java.sql.Date;
import java.time.LocalDate;

public class Card {
    private int id;
    private Book book;
    private Student student;
    private boolean status;
    private Date borrowDay;
    private Date returnDay;

    public Card() {
    }

    public Card(Book book, Student student, boolean status, Date borrowDay, Date returnDay) {
        this.book = book;
        this.student = student;
        this.status = status;
        this.borrowDay = borrowDay;
        this.returnDay = returnDay;
    }

    public Card(int id, Book book, Student student, boolean status, Date borrowDay, Date returnDay) {
        this.id = id;
        this.book = book;
        this.student = student;
        this.status = status;
        this.borrowDay = borrowDay;
        this.returnDay = returnDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(Date borrowDay) {
        this.borrowDay = borrowDay;
    }

    public Date getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(Date returnDay) {
        this.returnDay = returnDay;
    }
}
