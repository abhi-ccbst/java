Exercise: Library System
Objective:
Create a library system that uses inheritance, polymorphism, and enums to manage different types of books and their categories. You will define an abstract class for books, extend it with specific book types, and use polymorphism to handle the display of book details. You will also use enums to represent book categories and book formats.

Requirements:
Define an Enum for Book Category:

Create an enum BookCategory to represent different categories of books. Possible values should include:
FICTION
NON_FICTION
SCIENCE
HISTORY
FANTASY
Define an Enum for Book Format:

Create an enum BookFormat to represent different formats of books. Possible values should include:
HARDCOVER
PAPERBACK
EBOOK
AUDIOBOOK
Create an Abstract Class Book:

Define an abstract class Book with the following attributes and methods:
String title
String author
int publicationYear
BookCategory category (Use the BookCategory enum)
BookFormat format (Use the BookFormat enum)
double price
An abstract method displayDetails() which should print the details of the book (title, author, publication year, category, format, and price).
Create Concrete Subclasses of Book:

Define the following subclasses of Book:
FictionBook: Representing fiction books. This class should have an additional attribute int numberOfPages and implement the displayDetails() method to print the book details along with the number of pages.
NonFictionBook: Representing non-fiction books. This class should have an additional attribute String subjectArea (the subject or field of study) and implement the displayDetails() method to print the book details along with the subject area.
Ebook: Representing e-books. This class should have an additional attribute double fileSize (in MB) and implement the displayDetails() method to print the book details along with the file size.
Polymorphism:

In the main method, create a collection of books (using an array or list) that includes instances of FictionBook, NonFictionBook, and Ebook. Iterate over the collection and call displayDetails() on each book, demonstrating polymorphism as each subclass provides its own implementation of displayDetails().
Optional Advanced Task:

Implement a method findBookByCategory(BookCategory category) in the Library class, which filters and prints books that belong to a specific category (e.g., all FICTION books).