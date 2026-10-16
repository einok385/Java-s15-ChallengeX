package com.kutuphane.model;

public class Journals extends Book {
    public Journals(String id, String title, Author author, double price) {
        // Üst sınıfa (Book) kategoriyi otomatik "Journal" olarak gönderiyoruz
        super(id, title, author, "Journal", price);
    }
}
