
package com.kutuphane.model;

public class Magazines extends Book {
    public Magazines(String id, String title, Author author, double price) {
        // Üst sınıfa (Book) kategoriyi otomatik "Magazine" olarak gönderiyoruz
        super(id, title, author, "Magazine", price);
    }
}