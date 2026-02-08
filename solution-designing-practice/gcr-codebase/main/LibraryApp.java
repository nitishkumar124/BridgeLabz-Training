package main;

import book.Book;
import catalog.LibraryCatalog;
import user.User;
import user.UserFactory;

public class LibraryApp {

    public static void main(String[] args) {

        LibraryCatalog catalog = LibraryCatalog.getInstance();

        User student = UserFactory.createUser("student", "Alice");
        User faculty = UserFactory.createUser("faculty", "Dr Bob");
        User librarian = UserFactory.createUser("librarian", "Mr John");

        student.showRole();
        faculty.showRole();
        librarian.showRole();

        catalog.addObserver(student);
        catalog.addObserver(faculty);
        catalog.addObserver(librarian);

        Book book1 = new Book.BookBuilder("Design Patterns")
                .author("GoF")
                .edition("2nd")
                .genre("Software Engineering")
                .build();

        Book book2 = new Book.BookBuilder("Data Structures")
                .author("Cormen")
                .edition("3rd")
                .genre("Computer Science")
                .build();

        catalog.addBook(book1);
        catalog.addBook(book2);

        catalog.displayBooks();
    }
}
