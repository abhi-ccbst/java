package library;

import enums.BookCategory;
import enums.BookFormat;

class FictionBook extends Book {
    private int numberOfPages;

    // Constructor
    public FictionBook(String title, String author, int publicationYear, BookCategory category, BookFormat format, double price, int numberOfPages) {
        super(title, author, publicationYear, category, format, price);
        this.numberOfPages = numberOfPages;
    }

    // Implementing displayDetails for FictionBook
    @Override
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Category: " + category);
        System.out.println("Format: " + format);
        System.out.println("Price: $" + price);
        System.out.println("Pages: " + numberOfPages);
        System.out.println();
    }
}

