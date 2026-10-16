package com.kutuphane.model;

public class StudyBooks extends Book {
    public StudyBooks(String id, String title, Author author, double price) {
        // Üst sınıfa (Book) kategoriyi otomatik "StudyBook" olarak gönderiyoruz
        super(id, title, author, "StudyBook", price);
    }
}
