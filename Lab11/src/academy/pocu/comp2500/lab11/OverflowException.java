package academy.pocu.comp2500.lab11;

public class OverflowException extends RuntimeException {
    private static final long serialVersionUID = -6184044926029705156L;

    public OverflowException(String msg) {
        super(msg);
    }
}
