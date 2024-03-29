package academy.pocu.comp2500.lab5;

import academy.pocu.comp2500.lab5.Barbarian;

import java.util.HashMap;
import java.util.Map;

public class Gladiator extends Barbarian {
    protected final Map<String, Move> moveMap;

    public Gladiator(final String name, final int maxHp, final int attackPower, final int defensePower) {
        super(name, maxHp, attackPower, defensePower);
        this.moveMap = new HashMap<>();
    }

    public boolean addMove(final Move move) {
        final String moveName = move.getName();

        if (this.moveMap.containsKey(moveName) || this.moveMap.size() >= 4) {
            return false;
        }

        this.moveMap.put(moveName, move);

        return true;
    }

    public boolean removeMove(final String moveName) {
        if (this.moveMap.containsKey(moveName)) {
            this.moveMap.remove(moveName);
            return true;
        }

        return false;
    }

    public void attack(final String name, final Barbarian gladiator) {
        if (this == gladiator) {
            return;
        }

        if (this.moveMap.containsKey(name) == false) {
            return;
        }

        if (gladiator.isAlive() == false || this.isAlive() == false) {
            return;
        }

        final Move move = this.moveMap.get(name);

        if (move.isAvailable() == false) {
            return;
        }

        move.usePoint();
        final double damage = (this.attackPower / (double) gladiator.defensePower * (double) move.getPower()) / (double) 2;

        gladiator.currentHp -= Math.max((int) damage, 1);
        gladiator.currentHp = Math.max(gladiator.currentHp, 0);
    }

    public void rest() {
        this.currentHp = Math.min(this.maxHp, this.currentHp + 10);

        for (Map.Entry<String, Move> entry : this.moveMap.entrySet()) {
            entry.getValue().rest();
        }
    }
}
