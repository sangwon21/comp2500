package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Menu {
    protected int price;
    protected boolean valid;

    protected Menu(int price) {
        this.price = price;
        this.valid = false;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isValid() {
        return this.valid;
    }
}
