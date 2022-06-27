package academy.pocu.comp2500.lab7;

public class Author {
    private String firstName;
    private String lastName;

    public Author(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj instanceof Author == false || obj.hashCode() != this.hashCode()) {
            return false;
        }

        Author other = (Author) obj;

        return other.firstName.equals(this.firstName) && other.lastName.equals(this.lastName);
    }

    @Override
    public int hashCode() {
        return this.firstName.hashCode() ^ (this.lastName.hashCode() << 3) + 7 * 31;
    }
}
