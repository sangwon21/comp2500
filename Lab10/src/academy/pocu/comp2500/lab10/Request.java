package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.User;

public class Request {
    private final String title;
    private User user;

    public Request(String title) {
        this.title = title;
        this.user = new User("", "");
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Request) || obj.hashCode() != this.hashCode()) {
            return false;
        }

        Request other = (Request) obj;

        return this.title.equals(other.title) && this.user.equals(other.user);
    }

    @Override
    public int hashCode() {
        return this.title.hashCode() ^ this.user.hashCode() << 13;
    }
}
