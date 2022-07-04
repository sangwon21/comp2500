package academy.pocu.comp2500.assignment3;

import java.util.HashSet;

public class SmartMine extends Mine implements IThinkable {
    private static final int VISION = 1;
    private static final int AREA_OF_EFFECT = 1;
    private static final int AP = 15;
    private static final EUnitType[] POSSIBLE_ATTACK_UNIT_TYPES = {EUnitType.GROUND, EUnitType.INVISIBLE};
    private final int minimumEnemyCount;

    public SmartMine(final IntVector2D position, final int threshold, final int minimumEnemyCount) {
        super(position, threshold, Symbol.SMART_MINE);
        this.action = EActionType.NOTHING;
        this.minimumEnemyCount = minimumEnemyCount;
    }

    @Override
    public void onSpawn() {
        super.onSpawn();
        SimulationManager.getInstance().registerThinkable(this);
    }

    @Override
    public void onRemove() {
        super.onRemove();
        SimulationManager.getInstance().removeThinkable(this);
    }

    @Override
    public AttackIntent attack() {
        AttackIntent attackIntentOrNull = super.attack();

        if (attackIntentOrNull != null) {
            AttackIntent revisedApAttackIntent = new AttackIntent(attackIntentOrNull, AP, AREA_OF_EFFECT);
            return revisedApAttackIntent;
        }

        if (this.action != EActionType.ATTACK) {
            return null;
        }

        return new AttackIntent(this, this.position.getY(), this.position.getX(), AP, AREA_OF_EFFECT, POSSIBLE_ATTACK_UNIT_TYPES, true);
    }

    @Override
    public void think() {
        if (findEnemies() == false) {
            this.action = EActionType.NOTHING;
            return;
        }

        this.action = EActionType.ATTACK;
    }

    private boolean findEnemies() {
        BattleField battleField = SimulationManager.getInstance().getBattleField();

        int foundUnitCount = 0;

        int minY = this.position.getY() - VISION;
        int minX = this.position.getX() - VISION;

        int maxY = this.position.getY() + VISION;
        int maxX = this.position.getX() + VISION;

        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                if (battleField.isValidPosition(y, x) == false) {
                    continue;
                }

                HashSet<Unit> unitSet = battleField.getUnitsFromPosition(y, x);

                for (Unit unit : unitSet) {
                    if (unit == this || unit.unitType != EUnitType.GROUND) {
                        continue;
                    }

                    foundUnitCount++;
                }
            }
        }


        return foundUnitCount >= this.minimumEnemyCount;
    }
}
