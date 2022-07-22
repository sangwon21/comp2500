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
}
