package academy.pocu.comp2500.assignment3;

import java.util.HashSet;

public class Mine extends Unit implements ICollidable {
    private static final char SYMBOL = 'T';
    private static final int VISION = 3;
    private static final int AREA_OF_EFFECT = 1;
    private static final int AP = 8;
    private static final int HP = 85;
    private static final EUnitType[] POSSIBLE_ATTACK_UNIT_TYPES = {EUnitType.GROUND};
    private int threshold;


    public Mine(IntVector2D position, int threshold) {
        super(position, HP, SYMBOL, EUnitType.GROUND);
        this.threshold = threshold;

    }

    public void onSpawn() {
        SimulationManager.getInstance().registerCollisionEventListener(this);
    }

    public void collide(Unit unit) {
        if (unit == this || unit.unitType == EUnitType.AIR) {
            return;
        }

        this.threshold -= 1;
    }

    public AttackIntent attack() {
        if (this.threshold != 0) {
            return null;
        }

        return new AttackIntent(this, 1, 1, AP, AREA_OF_EFFECT, POSSIBLE_ATTACK_UNIT_TYPES);
    }

    @Override
    public void onAttacked(int damage) {
        this.hp = 0;
    }
}
