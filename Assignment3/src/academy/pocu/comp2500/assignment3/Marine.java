package academy.pocu.comp2500.assignment3;

import java.util.HashSet;

public class Marine extends Unit implements IThinkable, IMovable {
    private static final char SYMBOL = 'M';
    private static final int VISION = 2;
    private static final int AREA_OF_EFFECT = 0;
    private static final int AP = 6;
    private static final int HP = 35;
    private static final EUnitType[] POSSIBLE_ATTACK_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR};
    private static final IntVector2D[] ATTACK_AREA_RANGE = {
            new IntVector2D(0, 0),
            new IntVector2D(0, -1),
            new IntVector2D(1, 0),
            new IntVector2D(0, 1),
            new IntVector2D(-1, 0),
    };
    private static final IntVector2D[] VISION_OFFSETS = getVisionOffsets(VISION);

    private Unit targetOrNull;

    public Marine(IntVector2D position) {
        super(position, HP, SYMBOL, EUnitType.GROUND);
    }

    public void onSpawn() {
        SimulationManager.getInstance().registerThinkable(this);
        SimulationManager.getInstance().registerMovable(this);
    }

    public void think() {
        this.targetOrNull = findAttackTargetOrNull();
        if (this.targetOrNull != null) {
            this.action = EActionType.ATTACK;
            return;
        }

        this.targetOrNull = findNextMovePosition();
        if (this.targetOrNull != null) {
            this.action = EActionType.MOVE;
            return;
        }

        this.action = EActionType.NOTHING;
    }

    public void move() {
        if (this.action != EActionType.MOVE) {
            return;
        }

        IntVector2D targetOrNullPosition = this.targetOrNull.getPosition();

        BattleField battleField = SimulationManager.getInstance().getBattleField();

        int targetY = targetOrNullPosition.getY();
        int targetX = targetOrNullPosition.getX();

        int toY = this.position.getY();
        int toX = this.position.getX();
        if (targetY != this.position.getY()) {
            if (this.position.getY() < targetY) {
                toY += 1;
            } else {
                toY -= 1;
            }
        } else if (targetX != this.position.getX()) {
            if (this.position.getX() < targetX) {
                toX += 1;
            } else {
                toX -= 1;
            }
        }

        battleField.move(this.position.getY(), this.position.getX(), toY, toX, this);
        this.position.setX(toX);
        this.position.setY(toY);

    }

    public AttackIntent attack() {
        if (this.action != EActionType.ATTACK) {
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
                if (unit == this) {
                    continue;
                }

                if (targetOrNull == null) {
                    targetOrNull = unit;
                    continue;
                }

                if (targetOrNull.getHp() > unit.getHp()) {
                    targetOrNull = unit;
                }
            }
        }

        return targetOrNull;
    }

    private Unit findNextMovePosition() {
        BattleField battleField = SimulationManager.getInstance().getBattleField();
        Unit targetOrNull = null;
        int minDistance = Integer.MAX_VALUE;

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
                if (unit == this) {
                    continue;
                }

                int distance = getDistanceFrom(unit);

                if (targetOrNull == null) {
                    targetOrNull = unit;
                    minDistance = distance;
                    continue;
                }

                if (minDistance > distance) {
                    targetOrNull = unit;
                    minDistance = distance;
                    continue;
                }

                if (minDistance == distance) {
                    if (targetOrNull.getHp() > unit.getHp()) {
                        targetOrNull = unit;
                    }
                }
            }
        }

        if (targetOrNull == null) {
            return null;
        }

        return targetOrNull;
    }
}
