package academy.pocu.comp2500.lab5;

public class Barbarian {
    protected String name;
    protected int maxHp;
    protected int currentHp;
    protected int attackPower;
    protected int defensePower;

    public Barbarian(final String name, final int maxHp, final int attackPower, final int defensePower) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    public int getHp() {
        return this.currentHp;
    }

    public void attack(Barbarian barbarian) {
        final int damage = Math.max((this.attackPower - barbarian.defensePower) / 2, 1);

        barbarian.currentHp -= damage;
    }

    public boolean isAlive() {
        return this.currentHp > 0;
    }
}
