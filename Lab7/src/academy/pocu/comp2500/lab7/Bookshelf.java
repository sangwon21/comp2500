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
}
