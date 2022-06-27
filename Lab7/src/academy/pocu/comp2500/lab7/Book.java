package academy.pocu.comp2500.lab7;

public class Book {
    private String title;
    private Author author;
    private int publishedYear;
    private Genre genre;

    public Book(String title, Author author, int publishedYear, Genre genre) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return String.format("%s [%s]", title, this.author);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.hashCode() != this.hashCode()) {
            return false;
        }

        Book other = (Book) obj;

        return other.title.equals(this.title) && other.author.equals(this.author) && other.publishedYear == this.publishedYear && other.genre == this.genre;
    }

    @Override
    public int hashCode() {
        return this.title.hashCode() ^ (this.author.hashCode() << 16) ^ this.publishedYear ^ this.genre.hashCode();
    }
}
