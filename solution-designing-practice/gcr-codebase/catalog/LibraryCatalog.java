package catalog;

import java.util.ArrayList;
import java.util.List;
import observer.Observer;
import book.Book;

public class LibraryCatalog {

    private static LibraryCatalog instance;

    private List<Book> books;
    private List<Observer> observers;

    private LibraryCatalog() {
        books = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static synchronized LibraryCatalog getInstance() {
        if (instance == null) {
            instance = new LibraryCatalog();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void addBook(Book book) {
        books.add(book);
        notifyObservers(book.getTitle());
    }

    private void notifyObservers(String bookTitle) {
        for (Observer observer : observers) {
            observer.update("New book available: " + bookTitle);
        }
    }
    public void displayBooks() {
        System.out.println("\nLibrary Catalog:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
