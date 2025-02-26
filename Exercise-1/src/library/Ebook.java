package library;

import enums.BookCategory;
import enums.BookFormat;

public class Ebook extends Book {
    private double fileSize;

    // Constructor
    public Ebook(String title, String author, int publicationYear, BookCategory category, BookFormat format, double price, double fileSize) {
        super(title, author, publicationYear, category, format, price);
        this.fileSize = fileSize;
    }

    // Implementing displayDetails for Ebook
    @Override
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Category: " + category);
        System.out.println("Format: " + format);
        System.out.println("Price: $" + price);
        System.out.println("File Size: " + fileSize + " MB");
        System.out.println();
    }
}
