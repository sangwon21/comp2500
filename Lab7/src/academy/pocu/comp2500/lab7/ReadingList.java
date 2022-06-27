package academy.pocu.comp2500.lab7;

import java.util.ArrayList;
import java.util.List;

public class ReadingList {
    private String title;
    private List<Book> books;

    public ReadingList(final String title) {
        this.title = title;
        this.books = new ArrayList<>();
    }

    public void add(final Book book) {
        this.books.add(book);
    }

    public boolean remove(final Book book) {
        return this.books.remove(book);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < this.books.size(); i++) {
            stringBuilder.append(String.format("%d. %s", i + 1, this.books.get(i)));
        }

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj instanceof ReadingList == false || obj.hashCode() != this.hashCode()) {
            return false;
        }

        ReadingList other = (ReadingList) obj;

        if (this.title.equals(other.title) == false) {
            return false;
        }

        if (this.books.size() != other.books.size()) {
            return false;
        }

        for (int i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).equals(other.books.get(i)) != false) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int sum = this.title.hashCode();

        for (int i = 0; i < this.books.size(); i++) {
            sum ^= this.books.get(i).hashCode();
        }

        return sum;
    }
}
