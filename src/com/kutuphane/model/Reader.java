
package com.kutuphane.model;
import java.util.ArrayList;
import java.util.List;
public class Reader extends Person {
    private List<Book> borrowedBooks = new ArrayList<>();
    public Reader(String name) { super(name); }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
    public void borrowBook(Book book) { this.borrowedBooks.add(book); }
    public void returnBook(Book book) { this.borrowedBooks.remove(book); }
}