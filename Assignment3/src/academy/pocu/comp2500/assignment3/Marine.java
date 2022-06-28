package academy.pocu.comp2500.assignment3;

import academy.pocu.comp2500.Symbol;

import java.util.HashSet;

public class Marine extends Unit implements IThinkable, IMovable {
    private static final int VISION = 2;
    private static final int AREA_OF_EFFECT = 0;
    private static final int AP = 6;
    private static final int HP = 35;
    private static final EUnitType[] POSSIBLE_ATTACK_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR, EUnitType.INVISIBLE};
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
        super(position, HP, Symbol.Marine, EUnitType.GROUND);
    }

    @Override
    public void onSpawn() {
        SimulationManager.getInstance().registerThinkable(this);
        SimulationManager.getInstance().registerMovable(this);
    }

    @Override
    public void onRemove() {
        SimulationManager.getInstance().removeMovable(this);
        SimulationManager.getInstance().removeThinkable(this);
    }

    @Override
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

    @Override
    public void move() {
        if (this.action != EActionType.MOVE) {
            return;
        }

        IntVector2D targetOrNullPosition = this.targetOrNull.getPosition();

        BattleField battleField = SimulationManager.getInstance().getBattleField();

        int targetY = targetOrNullPosition.getY();
        int targetX = targetOrNullPosition.getX();

        int fromY = this.position.getY();
        int fromX = this.position.getX();

        if (targetY != this.position.getY()) {
            if (this.position.getY() < targetY) {
                fromY += 1;
            } else {
                fromY -= 1;
            }
        } else if (targetX != this.position.getX()) {
            if (this.position.getX() < targetX) {
                fromX += 1;
            } else {
                fromX -= 1;
            }
        }

        battleField.move(this.position.getY(), this.position.getX(), fromY, fromX, this);
        this.position.setX(fromX);
        this.position.setY(fromY);
    }

    @Override
    public AttackIntent attack() {
        if (this.action != EActionType.ATTACK) {
            return null;
        }

        final IntVector2D targetPosition = this.targetOrNull.getPosition();

        return new AttackIntent(this, targetPosition.getY(), targetPosition.getX(), AP, AREA_OF_EFFECT, POSSIBLE_ATTACK_UNIT_TYPES, false);
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
                if (unit == this || unit.unitType == EUnitType.INVISIBLE) {
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
                if (unit == this || unit.unitType == EUnitType.INVISIBLE) {
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
