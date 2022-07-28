package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;

public final class SafeWallet extends Wallet {
    public SafeWallet(User user) throws IllegalAccessException {
        super(user);
    }

    public boolean deposit(int amount) {
        if (getAmount() > 0 && getAmount() + amount <= 0) {
            throw new OverflowException("Overflow");
        }

        return super.deposit(amount);
    }
}
