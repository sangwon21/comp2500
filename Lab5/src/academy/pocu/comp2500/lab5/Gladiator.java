package academy.pocu.comp2500.lab5;

import academy.pocu.comp2500.lab5.Barbarian;

import java.util.HashMap;
import java.util.Map;

public class Gladiator extends Barbarian {
    private Map<String, Move> moveMap;

    public Gladiator(final String name, final int maxHp, final int attackPower, final int defensePower) {
        super(name, maxHp, attackPower, defensePower);
        this.moveMap = new HashMap<>();
    }

    public boolean addMove(Move move) {
        final String moveName = move.getName();

        if (this.moveMap.containsKey(moveName)) {
            return false;
        }

        this.moveMap.put(moveName, move);

        return true;
    }

    public boolean removeMove(Move move) {
        final String moveName = move.getName();

        if (this.moveMap.containsKey(moveName)) {
            this.moveMap.remove(moveName);
            return true;
        }

        return false;
    }

    public void attack(String name, Gladiator gladiator) {
        if (this.moveMap.containsKey(name) == false) {
            return;
        }

        final Move move = this.moveMap.get(name);

        if (move.isAvailable() == false) {
            return;
        }

        move.usePoint();
        final int damage = Math.max((this.attackPower / gladiator.defensePower * move.getPower()) / 2, 1);

        gladiator.hp -= damage;
    }
}
