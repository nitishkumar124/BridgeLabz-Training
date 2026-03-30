package week2.smart_shelf;

import java.util.ArrayList;
import java.util.List;

class ReadingList {
    private List<Book> books = new ArrayList<>();

    // Real-time sorting logic
    public void addBook(Book newBook) {
        books.add(newBook); // Step 1: Add to the end
        insertionSortLatest(); // Step 2: Sort the new entry into position
        System.out.println("Added and sorted: " + newBook.title);
    }

    private void insertionSortLatest() {
        int n = books.size();
        if (n <= 1) return;

        // We only need to place the last element added
        int i = n - 1;
        Book key = books.get(i);
        int j = i - 1;

        /* Move elements of books.get(0..i-1) that are greater than 
           the key title, to one position ahead of their current position */
        while (j >= 0 && books.get(j).title.compareToIgnoreCase(key.title) > 0) {
            books.set(j + 1, books.get(j));
            j = j - 1;
        }
        books.set(j + 1, key);
    }

    public void displayList() {
        System.out.println("\n--- Current Reading List (Alphabetical) ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }
}