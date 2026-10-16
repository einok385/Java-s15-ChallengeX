package com.kutuphane;

import com.kutuphane.model.*;
import com.kutuphane.service.Library;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Test Verileri Yükleme (Yazar parametreleri new Author() nesnesine dönüştürüldü)
        library.addBook(new StudyBooks("101", "Clean Code", new Author("Martin Fowler"), 150.0));
        library.addBook(new Magazines("202", "Bilim Teknik", new Author("Yaşar Kemal"), 45.0));

        while (true) {
            System.out.println("\n--- LIBRARY AUTOMATION SYSTEM ---");
            System.out.println("1. Yeni Kitap Ekle");
            System.out.println("2. Kitap Ara (ID veya İsim)");
            System.out.println("3. Kitap Güncelle");
            System.out.println("4. Kitap Sil");
            System.out.println("5. Kategoriye Göre Listele");
            System.out.println("6. Yazara Göre Listele");
            System.out.println("7. Kitap Ödünç Al");
            System.out.println("8. Kitap İade Et");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Boş satır karakterini temizle

            if (choice == 0) {
                System.out.println("Sistemden çıkılıyor...");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("İsim: ");
                    String name = scanner.nextLine();
                    System.out.print("Yazar İsmi: ");
                    String authorName = scanner.nextLine();
                    System.out.print("Kategori: ");
                    String category = scanner.nextLine();
                    System.out.print("Fiyat: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    // Book kurucusuna yeni Author nesnesi ve fiyat gönderiliyor
                    library.addBook(new Book(id, name, new Author(authorName), category, price));
                    break;

                case 2:
                    System.out.print("ID veya Kitap Adı Girin: ");
                    String searchKey = scanner.nextLine();
                    Book foundBook = library.findBook(searchKey);
                    if (foundBook != null) {
                        System.out.println("Kitap Bulundu: " + foundBook.getTitle() + " - " + foundBook.getAuthor().getName());
                    } else {
                        System.out.println("Kitap bulunamadı.");
                    }
                    break;

                case 3:
                    System.out.print("Güncellenecek Kitap ID: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Yeni İsim: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Yeni Yazar: ");
                    String newAuthor = scanner.nextLine();

                    library.updateBook(updateId, newTitle, newAuthor);
                    break;

                case 4:
                    System.out.print("Silinecek Kitap ID: ");
                    library.deleteBook(scanner.nextLine());
                    break;

                case 5:
                    System.out.print("Kategori Adı: ");
                    library.listByCategory(scanner.nextLine());
                    break;

                case 6:
                    System.out.print("Yazar Adı: ");
                    library.listByAuthor(scanner.nextLine());
                    break;

                case 7:
                    System.out.print("Ödünç Alınacak Kitap ID/Adı: ");
                    String bKey = scanner.nextLine();
                    System.out.print("Kullanıcı Adı: ");
                    String uName = scanner.nextLine();
                    library.borrowBook(bKey, uName);
                    break;

                case 8:
                    System.out.print("İade Edilecek Kitap ID/Adı: ");
                    library.returnBook(scanner.nextLine());
                    break;

                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
        scanner.close();
    }
}
