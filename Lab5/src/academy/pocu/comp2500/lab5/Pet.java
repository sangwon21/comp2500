package academy.pocu.comp2500.lab5;

public class Pet {
    private String name;
    private int attackPower;

    public Pet(String name, int attackPower) {
        this.name = name;
        this.attackPower = attackPower;
    }

    public int getAttackPower() {
        return this.attackPower;
    }
}
