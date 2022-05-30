package academy.pocu.comp2500.lab5;

public class Barbarian {
    private String name;
    private int hp;
    private int attack;
    private int defense;

    public Barbarian(final String name, final int maxHp, final int attack, final int defense) {
        this.name = name;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
    }

    public int getHp() {
        return this.hp;
    }

    public void attack(Barbarian barbarian) {
        final int damage = Math.max((this.attack - barbarian.defense) / 2, 1);

        barbarian.hp -= damage;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }
}
