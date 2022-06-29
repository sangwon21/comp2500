package academy.pocu.comp2500.assignment3;

import java.util.HashSet;

public class Tank extends Unit implements IMovable, IThinkable {
    private static final int VISION = 3;
    private static final int AREA_OF_EFFECT = 1;
    private static final int AP = 8;
    private static final int HP = 85;
    private static final EUnitType[] POSSIBLE_ATTACK_UNIT_TYPES = {EUnitType.GROUND, EUnitType.INVISIBLE};
    private static final IntVector2D[] ATTACK_AREA_RANGE = {
            new IntVector2D(0, -2),
            new IntVector2D(1, -2),
            new IntVector2D(2, -1),
            new IntVector2D(2, 0),
            new IntVector2D(2, 1),
            new IntVector2D(1, 2),
            new IntVector2D(0, 2),
            new IntVector2D(-1, 2),
            new IntVector2D(-2, 1),
            new IntVector2D(-2, 0),
            new IntVector2D(-2, -1),
            new IntVector2D(-1, -2),
    };
    private static final IntVector2D[] VISION_OFFSETS = getVisionOffsets(VISION);
    private Unit targetOrNull;
    private ETankMode mode;
    private boolean moveToRightDirection;

    public Tank(IntVector2D position) {
        super(position, HP, Symbol.Tank, EUnitType.GROUND);
        this.mode = ETankMode.TANK;
        this.moveToRightDirection = true;
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
        // 공격가능
        if (this.targetOrNull != null) {
            if (this.mode == ETankMode.SIEGE) {
                this.action = EActionType.ATTACK;
                return;
            }

            this.mode = ETankMode.SIEGE;
            this.action = EActionType.NOTHING;
            return;
        }

        // 시야에 확보
        if (findTargetInVisionOrNull() != null) {
            if (this.mode == ETankMode.TANK) {
                this.mode = ETankMode.SIEGE;
            }

            this.action = EActionType.NOTHING;
            return;
        }

        // 이동
        if (this.mode == ETankMode.TANK) {
            this.action = EActionType.MOVE;
            return;
        }

        this.mode = ETankMode.TANK;
        this.action = EActionType.NOTHING;
    }

    @Override
    public void move() {
        if (this.action != EActionType.MOVE) {
            return;
        }

        BattleField battleField = SimulationManager.getInstance().getBattleField();

        int toX = this.position.getX();
        if (this.moveToRightDirection) {
            if (this.position.getX() == BattleField.X_LENGTH - 1) {
                this.moveToRightDirection = false;
                toX -= 1;
            } else {
                toX += 1;
            }
        } else {
            if (this.position.getX() == 0) {
                this.moveToRightDirection = true;
                toX += 1;
            } else {
                toX -= 1;
            }
        }

        battleField.move(this.position.getY(), this.position.getX(), this.position.getY(), toX, this);
        this.position.setX(toX);
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
        if (this.mode == ETankMode.SIEGE) {
            this.hp -= damage * 2;
            return;
        }

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

    private Unit findTargetInVisionOrNull() {
        BattleField battleField = SimulationManager.getInstance().getBattleField();
        Unit targetOrNull = null;

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

                return targetOrNull;
            }
        }

        return targetOrNull;
    }
}
