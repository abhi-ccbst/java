import enums.BookCategory;
import enums.BookFormat;
import library.Book;
import library.Ebook;
import library.NonFictionBook;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Creating a list of books
        ArrayList<Book> books = new ArrayList<>();

        // Adding books to the list
        books.add(new NonFictionBook("The Hobbit", "J.R.R. Tolkien", 1937, BookCategory.FICTION, BookFormat.HARDCOVER, 20.99, "Fiction"));
        books.add(new NonFictionBook("The Origin of Species", "Charles Darwin", 1859, BookCategory.NON_FICTION, BookFormat.PAPERBACK, 15.50, "Biology"));
        books.add(new Ebook("Java Programming", "John Doe", 2020, BookCategory.SCIENCE, BookFormat.EBOOK, 9.99, 1.2));

        // Displaying details of each book using polymorphism
        for (Book book : books) {
            book.displayDetails();  // Polymorphism in action
        }
    }

}