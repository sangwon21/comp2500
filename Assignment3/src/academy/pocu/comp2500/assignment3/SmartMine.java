package academy.pocu.comp2500.assignment3;

import java.util.HashSet;

public class SmartMine extends Mine implements IThinkable {
    private static final int VISION = 1;
    private static final int AREA_OF_EFFECT = 1;
    private static final int AP = 15;
    private static final EUnitType[] POSSIBLE_ATTACK_UNIT_TYPES = {EUnitType.GROUND, EUnitType.INVISIBLE};
    private static final IntVector2D[] VISION_OFFSETS = getVisionOffsets(VISION);
    private final int minimumEnemyCount;

    public SmartMine(final IntVector2D position, final int threshold, final int minimumEnemyCount) {
        super(position, threshold, Symbol.SmartMine);
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
            return attackIntentOrNull;
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

        for (IntVector2D offset : VISION_OFFSETS) {
            int offsetY = offset.getY();
            int offsetX = offset.getX();

            int targetY = offsetY + position.getY();
            int targetX = offsetX + position.getX();

            if (battleField.isValidPosition(targetY, targetX) == false) {
                continue;
            }

            HashSet<Unit> unitSet = battleField.getUnitsFromPosition(targetY, targetX);

            for (Unit unit : unitSet) {
                if (unit == this || unit.unitType != EUnitType.GROUND) {
                    continue;
                }

                foundUnitCount++;
            }
        }

        return foundUnitCount >= this.minimumEnemyCount;
    }
}
