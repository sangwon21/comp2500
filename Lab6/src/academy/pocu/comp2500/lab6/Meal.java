package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Meal extends Menu {
    protected ArrayList<Appetizer> appetizers;
    protected ArrayList<Dessert> desserts;
    protected ArrayList<MainCourse> mainCourses;

    protected Meal(int price) {
        super(price);
        this.appetizers = new ArrayList<>();
        this.desserts = new ArrayList<>();
        this.mainCourses = new ArrayList<>();
    }

    public ArrayList<Appetizer> getAppetizers() {
        return this.appetizers;
    }

    public ArrayList<MainCourse> getMainCourses() {
        return this.mainCourses;
    }

    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }
}
