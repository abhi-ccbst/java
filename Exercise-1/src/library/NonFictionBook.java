package library;

import enums.BookCategory;
import enums.BookFormat;

public class NonFictionBook extends Book {
    private String subjectArea;

    // Constructor
    public NonFictionBook(String title, String author, int publicationYear, BookCategory category, BookFormat format, double price, String subjectArea) {
        super(title, author, publicationYear, category, format, price);
        this.subjectArea = subjectArea;
    }

    // Implementing displayDetails for NonFictionBook
    @Override
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Category: " + category);
        System.out.println("Format: " + format);
        System.out.println("Price: $" + price);
        System.out.println("Subject Area: " + subjectArea);
        System.out.println();
    }
}

