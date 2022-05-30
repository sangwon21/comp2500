package academy.pocu.comp2500.lab5;

public class Knight extends Gladiator {
    private Pet petOrNull;

    public Knight(final String name, final int maxHp, final int attackPower, final int defensePower) {
        super(name, maxHp, attackPower, defensePower);
    }

    public void setPet(Pet petOrNull) {
        this.petOrNull = petOrNull;
    }

    public void attackTogether(Barbarian knight) {
        if (this.petOrNull == null) {
            return;
        }

        if (knight.isAlive() == false) {
            return;
        }

        final double damage = ((double) this.attackPower + (double) petOrNull.getAttackPower() - (double) knight.defensePower) / (double) 2;

        knight.currentHp -= Math.max((int) damage, 1);
        knight.currentHp = Math.max(knight.currentHp, 0);
    }
}
