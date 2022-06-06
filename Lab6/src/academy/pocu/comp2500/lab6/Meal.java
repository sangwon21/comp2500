package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Meal extends Menu{
    protected ArrayList<Appetizer> appetizers;
    protected ArrayList<Dessert> desserts;

    protected Meal(int price) {
        super(price);
        this.appetizers = new ArrayList<>();
        this.desserts = new ArrayList<>();
    }

    public ArrayList<Appetizer> getAppetizer() {
        return this.appetizers;
    }

    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }
}
