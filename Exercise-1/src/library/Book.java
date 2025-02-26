package library;

import enums.BookCategory;
import enums.BookFormat;

public abstract class Book {
    protected String title;
    protected String author;
    protected int publicationYear;
    protected BookCategory category;
    protected BookFormat format;
    protected double price;

    // Constructor
    public Book(String title, String author, int publicationYear, BookCategory category, BookFormat format, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.category = category;
        this.format = format;
        this.price = price;
    }

    // Abstract method to display book details
    public abstract void displayDetails();
}
