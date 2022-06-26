package academy.pocu.comp2500.assignment3;

import java.util.HashSet;

public class Turret extends Unit {
    private static final char SYMBOL = 'U';
    private static final int VISION = 2;
    private static final int AREA_OF_EFFECT = 0;
    private static final int AP = 7;
    private static final int HP = 99;
    private static final EUnitType[] POSSIBLE_ATTACK_UNIT_TYPES = {EUnitType.AIR};
    private static final IntVector2D[] ATTACK_AREA_RANGE = {
            new IntVector2D(0, 0),
            new IntVector2D(0, -1),
            new IntVector2D(1, -1),
            new IntVector2D(1, 0),
            new IntVector2D(1, 1),
            new IntVector2D(0, 1),
            new IntVector2D(-1, 1),
            new IntVector2D(-1, 0),
            new IntVector2D(-1, -1)
    };
    private static final IntVector2D[] VISION_OFFSETS = getVisionOffsets(VISION);

    public Turret(IntVector2D position) {
        super(position, HP, SYMBOL, EUnitType.GROUND);
        this.action = EActionType.ATTACK;
    }

    public void onSpawn() {
    }


    public AttackIntent attack() {
        Unit target = findAttackTargetOrNull();

        if (target == null) {
            return null;
        }

        return new AttackIntent(this, 1, 1, AP, AREA_OF_EFFECT, POSSIBLE_ATTACK_UNIT_TYPES);
    }

    @Override
    public void onAttacked(int damage) {

        this.hp -= damage;
    }

    private Unit findAttackTargetOrNull() {
        BattleField battleField = SimulationManager.getInstance().getBattleField();
        Unit targetOrNull = null;


        for (IntVector2D offset : ATTACK_AREA_RANGE) {
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

                if (targetOrNull == null) {
                    targetOrNull = unit;
                    continue;
                }

                if (targetOrNull.getHp() > unit.getHp()) {
                    targetOrNull = unit;
                    continue;
                }
            }
        }

        return targetOrNull;
    }
}
