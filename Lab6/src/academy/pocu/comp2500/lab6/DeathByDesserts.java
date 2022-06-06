package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class DeathByDesserts extends Meal {
    private static final int PRICE = 20;

    public DeathByDesserts() {
        super(PRICE);
    }
    private void checkValidity() {
        this.valid = this.desserts.size() == 4;
    }

    public void setDesserts(Dessert dessert1, Dessert dessert2, Dessert dessert3, Dessert dessert4) {
        this.desserts.clear();

        this.desserts.add(dessert1);
        this.desserts.add(dessert2);
        this.desserts.add(dessert3);
        this.desserts.add(dessert4);
        checkValidity();
    }
}