package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends Meal {
    private static final int PRICE = 25;
    private MainCourse mainCourse;

    public ThreeCourseMeal() {
        super(PRICE);
    }

    private void checkValidity() {
        this.valid = this.appetizers.size() == 1 && this.mainCourse != null && this.desserts.size() == 1;
    }

    public MainCourse getMainCourse() {
        assert (this.mainCourse != null) : "call isValid() first!";
        return this.mainCourse;
    }

    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourse = mainCourse;
        checkValidity();
    }

    public void setAppetizer(Appetizer appetizer) {
        this.appetizers.clear();
        this.appetizers.add(appetizer);
        checkValidity();
    }

    public void setDessert(Dessert dessert) {
        this.desserts.clear();
        this.desserts.add(dessert);
        checkValidity();
    }
}
