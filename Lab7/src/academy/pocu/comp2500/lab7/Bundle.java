package academy.pocu.comp2500.lab7;

import java.util.List;

public class Bundle {
    private String title;
    private Bookshelf bookshelf;

    public Bundle(final String title) {
        this.title = title;
        this.bookshelf = new Bookshelf(4);
    }

    public boolean add(Book book) {
        return this.bookshelf.add(book);
    }

    public boolean remove(Book book) {
        return this.bookshelf.remove(book);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj instanceof Bundle || obj.hashCode() != this.hashCode()) {
            return false;
        }

        Bundle other = (Bundle) obj;

        if (other.title.equals(this.title) == false) {
            return false;
        }

        return this.bookshelf.hasSameBooks(other.bookshelf);
    }

    @Override
    public int hashCode() {
        int sum = this.title.hashCode();
        List<Book> books = this.bookshelf.getBooks();

        for (int i = 0; i < books.size(); i++) {
            sum ^= books.get(i).hashCode();
        }

        return sum;
    }
}
