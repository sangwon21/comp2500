package academy.pocu.comp2500.lab5;

public class Move {
    private String name;
    private int power;
    private int currentPoint;
    private int maxPoint;

    public Move(final String name, final int power, final int point) {
        this.name = name;
        this.power = power;
        this.maxPoint = point;
        this.currentPoint = point;
    }

    public String getName() {
        return this.name;
    }

    public int getPower() {
        return this.power;
    }

    public boolean isAvailable() {
        return this.currentPoint > 0;
    }

    public void usePoint() {
        this.currentPoint -= 1;
        this.currentPoint = Math.max(0, this.currentPoint);
    }

    public void rest() {
        this.currentPoint = Math.max(this.maxPoint, this.currentPoint + 1);
    }
}
