package academy.pocu.comp2500.lab5;

public class Move {
    private String name;
    private int power;
    private int point;

    public Move(final String name, final int power, final int point) {
        this.name = name;
        this.power = power;
        this.point = point;
    }

    public String getName() {
        return this.name;
    }

    public int getPower() {
        return this.power;
    }

    public boolean isAvailable() {
        return this.point > 0;
    }

    public void usePoint() {
        this.point -= 1;
        this.point = Math.max(0, this.point);
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
