package academy.pocu.comp2500.assignment1;

public class User {
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.firstName + this.lastName;
    }
    
}
