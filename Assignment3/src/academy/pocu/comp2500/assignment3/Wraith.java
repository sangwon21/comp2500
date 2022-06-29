package academy.pocu.comp2500.assignment3;

import java.util.HashSet;

public class Wraith extends Unit implements IMovable, IThinkable {
    private static final int VISION = 4;
    private static final int AREA_OF_EFFECT = 0;
    private static final int AP = 6;
    private static final int HP = 80;
    private static final EUnitType[] POSSIBLE_ATTACK_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR, EUnitType.INVISIBLE};
    private static final IntVector2D[] ATTACK_AREA_RANGE = {
            new IntVector2D(0, 0),
            new IntVector2D(0, -1),
            new IntVector2D(1, 0),
            new IntVector2D(0, 1),
            new IntVector2D(-1, 0)
    };
    private static final IntVector2D[] VISION_OFFSETS = getVisionOffsets(VISION);
    private IntVector2D originalPosition;

    private Unit targetOrNull;
    private boolean hasShield;

    public Wraith(IntVector2D position) {
        super(position, HP, Symbol.Wraith, EUnitType.AIR);
        this.hasShield = true;
        this.originalPosition = position;
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

        this.action = EActionType.MOVE;
        this.targetOrNull = findNextMovePosition();
    }

    private void moveByOneUnit(int targetY, int targetX) {
        BattleField battleField = SimulationManager.getInstance().getBattleField();

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

    private void moveToTarget() {
        IntVector2D targetOrNullPosition = this.targetOrNull.getPosition();

        int targetY = targetOrNullPosition.getY();
        int targetX = targetOrNullPosition.getX();

        moveByOneUnit(targetY, targetX);
    }

    private void moveToOriginalPosition() {
        int targetY = this.originalPosition.getY();
        int targetX = this.originalPosition.getX();

        moveByOneUnit(targetY, targetX);
    }

    @Override
    public void move() {
        if (this.action != EActionType.MOVE) {
            return;
        }

        if (this.targetOrNull == null) {
            moveToOriginalPosition();
            return;
        }

        moveToTarget();
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
        if (this.hasShield) {
            this.hasShield = false;
            return;
        }

        this.hp -= damage;
    }

    private Unit findAttackTargetOrNull() {
        BattleField battleField = SimulationManager.getInstance().getBattleField();
        Unit airTargetOrNull = null;
        Unit groundTargetOrNull = null;

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

                if (unit.unitType == EUnitType.AIR) {
                    if (airTargetOrNull == null) {
                        airTargetOrNull = unit;
                        continue;
                    }

                    if (airTargetOrNull.getHp() > unit.getHp()) {
                        airTargetOrNull = unit;
                        continue;
                    }
                    continue;
                }

                if (groundTargetOrNull == null) {
                    groundTargetOrNull = unit;
                    continue;
                }

                if (groundTargetOrNull.getHp() > unit.getHp()) {
                    groundTargetOrNull = unit;
                }
            }
        }

        if (airTargetOrNull != null) {
            return airTargetOrNull;
        }

        return groundTargetOrNull;
    }

    private Unit findNextMovePosition() {
        BattleField battleField = SimulationManager.getInstance().getBattleField();
        Unit airTargetOrNull = null;
        int airMinDistance = Integer.MAX_VALUE;
        Unit groundTargetOrNull = null;
        int groundMinDistance = Integer.MAX_VALUE;

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

                if (unit.unitType == EUnitType.AIR) {
                    if (airTargetOrNull == null) {
                        airTargetOrNull = unit;
                        airMinDistance = distance;
                        continue;
                    }

                    if (airMinDistance < distance) {
                        continue;
                    }

                    if (airMinDistance > distance) {
                        airTargetOrNull = unit;
                        airMinDistance = distance;
                        continue;
                    }

                    if (airTargetOrNull.getHp() > unit.getHp()) {
                        airTargetOrNull = unit;
                        continue;
                    }
                    continue;
                }

                if (groundTargetOrNull == null) {
                    groundTargetOrNull = unit;
                    groundMinDistance = distance;
                    continue;
                }

                if (groundMinDistance < distance) {
                    continue;
                }

                if (groundMinDistance > distance) {
                    groundTargetOrNull = unit;
                    groundMinDistance = distance;
                    continue;
                }

                if (groundTargetOrNull.getHp() > unit.getHp()) {
                    groundTargetOrNull = unit;
                }
            }
        }

        if (airTargetOrNull != null) {
            return airTargetOrNull;
        }

        return groundTargetOrNull;
    }
}
