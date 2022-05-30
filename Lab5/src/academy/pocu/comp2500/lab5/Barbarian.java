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
        if (this == barbarian) {
            return;
        }

        if (barbarian.isAlive() == false || this.isAlive() == false) {
            return;
        }

        final double damage = (this.attackPower - barbarian.defensePower) / 2;

        barbarian.currentHp -= Math.max((int) damage, 1);
        barbarian.currentHp = Math.max(barbarian.currentHp, 0);
    }

    public boolean isAlive() {
        return this.currentHp > 0;
    }
}
