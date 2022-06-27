package academy.pocu.comp2500.lab7;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bookshelf {
    private List<Book> books;
    private int maxBookCapacity;

    public Bookshelf(final int maxBookCapacity) {
        this.maxBookCapacity = maxBookCapacity;
        this.books = new ArrayList<>(this.maxBookCapacity);
    }

    public boolean add(final Book book) {
        if (this.books.size() >= this.maxBookCapacity) {
            return false;
        }

        this.books.add(book);
        return true;
    }

    public boolean remove(final Book book) {
        return this.books.remove(book);
    }

    public List<Book> getBooks() {
        return this.books;
    }

    private HashMap<Book, Integer> putBookIntoHashMap(final List<Book> books) {
        HashMap<Book, Integer> bookMap = new HashMap<>();

        for (Book book : books) {
            if (bookMap.containsKey(book) == false) {
                bookMap.put(book, 1);
                continue;
            }

            int count = bookMap.get(book);
            bookMap.put(book, count + 1);
        }

        return bookMap;
    }

    public boolean hasSameBooks(final Bookshelf other) {
        List<Book> otherBooks = other.books;
        List<Book> thisBooks = this.books;

        if (otherBooks.size() != thisBooks.size()) {
            return false;
        }

        HashMap<Book, Integer> otherBookMap = putBookIntoHashMap(otherBooks);
        HashMap<Book, Integer> thisBookMap = putBookIntoHashMap(thisBooks);

        for (Map.Entry<Book, Integer> entry : thisBookMap.entrySet()) {
            final Book targetBook = entry.getKey();
            final int targetCount = entry.getValue();

            if (otherBookMap.containsKey(targetBook) == false) {
                return false;
            }

            final int otherBookCount = otherBookMap.get(targetBook);

            if (targetCount != otherBookCount) {
                return false;
            }
        }

        return true;
    }
}
