package academy.pocu.comp2500.lab7;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bundle {
    private String title;
    private Set<Book> set;



    public Bundle(final String title) {
        this.title = title;
        this.set = new HashSet<>();
    }

    public boolean add(Book book) {
        return this.set.add(book);
    }

    public boolean remove(Book book) {
        return this.set.remove(book);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj instanceof Bundle == false|| obj.hashCode() != this.hashCode()) {
            return false;
        }

        Bundle other = (Bundle) obj;

        if (other.title.equals(this.title) == false) {
            return false;
        }

        if (this.set.size() != other.set.size()) {
            return false;
        }

        for (Book book : this.set) {
            if (other.set.contains(book) == false) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int sum = this.title.hashCode();

        for (Book book : this.set) {
            sum ^= book.hashCode();
        }

        return sum;
    }
}
