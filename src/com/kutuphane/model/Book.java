package com.kutuphane.model;

public class Book {
    private String id;
    private String title;
    private Author author; // String yerine Author nesnesi yapıyoruz
    private String category;
    private double price;   // Fiyat alanını ekliyoruz
    private boolean isBorrowed;

    // Kurucu Metot (Sizin alt sınıfların beklediği parametre yapısı)
    public Book(String id, String title, Author author, String category, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.isBorrowed = false;
    }

    public double calculateInvoice() {
        return this.price; // Varsayılan fatura fiyatı kendi fiyatı olsun
    }

    // --- GETTER VE SETTER METOTLARI ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public boolean isBorrowed() { return isBorrowed; }
    public void setBorrowed(boolean borrowed) { isBorrowed = borrowed; }
}