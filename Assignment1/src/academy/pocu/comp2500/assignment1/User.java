package academy.pocu.comp2500.assignment1;

import java.util.UUID;

public class User {
    private String firstName;
    private String lastName;
    private UUID userId;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
