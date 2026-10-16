package com.kutuphane.service;

import com.kutuphane.model.Book;
import com.kutuphane.model.Reader;
import com.kutuphane.model.Author;
import java.util.*;

public class Library {
    private List<Book> bookList;
    private List<Reader> readerList;
    private Map<String, Book> bookMap;

    public Library() {
        this.bookList = new ArrayList<>();
        this.readerList = new ArrayList<>();
        this.bookMap = new HashMap<>();
    }

    public void addBook(Book book) {
        bookList.add(book);
        bookMap.put(book.getId().toLowerCase(), book);
        bookMap.put(book.getTitle().toLowerCase(), book);
        System.out.println("Kitap eklendi: " + book.getTitle());
    }

    public void addReader(Reader reader) {
        readerList.add(reader);
        System.out.println("Okuyucu eklendi: " + reader.getName());
    }

    public Book findBook(String searchKey) {
        if (searchKey == null) return null;
        return bookMap.get(searchKey.toLowerCase());
    }

    public void updateBook(String id, String newTitle, String newAuthor) {
        Book book = bookMap.get(id.toLowerCase());
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(new Author(newAuthor));
            System.out.println("=> Güncellendi.");
        } else {
            System.out.println("Bulunamadı.");
        }
    }

    public void deleteBook(String id) {
        Book book = bookMap.get(id.toLowerCase());
        if (book != null) {
            bookList.remove(book);
            bookMap.remove(id.toLowerCase());
            bookMap.remove(book.getTitle().toLowerCase());
            System.out.println("Kitap silindi.");
        } else {
            System.out.println("Silinecek kitap bulunamadı.");
        }
    }

    public void listByCategory(String category) {
        System.out.println("--- " + category + " Kategorisi ---");
        for (Book b : bookList) {
            if (b.getCategory().equalsIgnoreCase(category)) {
                System.out.println(b.getTitle());
            }
        }
    }

    public void listByAuthor(String author) {
        System.out.println("--- " + author + " Kitapları ---");
        for (Book b : bookList) {
            if (b.getAuthor().getName().equalsIgnoreCase(author)) {
                System.out.println(b.getTitle());
            }
        }
    }

    public void borrowBook(String searchKey, String userName) {
        Book book = findBook(searchKey);
        if (book != null) {
            if (!book.isBorrowed()) {
                book.setBorrowed(true);
                System.out.println(userName + " kitabı ödünç aldı.");
            } else {
                System.out.println("Kitap zaten ödünç alınmış.");
            }
        } else {
            System.out.println("Kitap bulunamadı.");
        }
    }

    public void returnBook(String searchKey) {
        Book book = findBook(searchKey);
        if (book != null && book.isBorrowed()) {
            book.setBorrowed(false);
            System.out.println("Kitap iade edildi.");
        } else {
            System.out.println("İade edilemedi veya kitap zaten kütüphanede.");
        }
    }
}