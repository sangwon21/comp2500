package academy.pocu.comp2500.lab5;

public class Pet {
    private final String name;
    private final int attackPower;

    public Pet(final String name, final int attackPower) {
        this.name = name;
        this.attackPower = attackPower;
    }

    public int getAttackPower() {
        return this.attackPower;
    }
}
