package academy.pocu.comp2500.assignment3;

import java.util.HashSet;

public class Tank extends Unit implements IMovable, IThinkable {
    private static final int VISION = 3;
    private static final int AREA_OF_EFFECT = 1;
    private static final int AP = 8;
    private static final int HP = 85;
    private static final EUnitType[] POSSIBLE_ATTACK_UNIT_TYPES = {EUnitType.GROUND};
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
    private IntVector2D targetOrNull;
    private ETankMode mode;
    private boolean moveToRightDirection;

    public Tank(IntVector2D position) {
        super(position, HP, Symbol.TANK, EUnitType.GROUND);
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
//        System.out.println("Tank Mode is " + this.mode);

        this.targetOrNull = findAttackTargetOrNull();
        // 공격가능
//        System.out.println("targetOrNull in Tank is " + this.targetOrNull);
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
        this.targetOrNull = findTargetInVisionOrNull();
//        System.out.println("Move TargetORNULL find target In Vision or Null" + this.targetOrNull);
        if (targetOrNull != null) {
            if (this.mode == ETankMode.TANK) {
                this.mode = ETankMode.SIEGE;
            }

            this.action = EActionType.NOTHING;
            return;
        }

        // 이동
//        System.out.println("FINAL MOVE");
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

        if (targetOrNull == null) {
            return null;
        }

        return new AttackIntent(this, targetOrNull.getY(), targetOrNull.getX(), AP, AREA_OF_EFFECT, POSSIBLE_ATTACK_UNIT_TYPES, false);
    }

    @Override
    public void onAttacked(int damage) {
        if (this.mode == ETankMode.SIEGE) {
            this.hp -= damage * 2;
            return;
        }

        this.hp -= damage;
    }

    private IntVector2D findAttackTargetOrNull() {
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

        if (targetOrNull == null) {
            return null;
        }

        return new IntVector2D(targetOrNull.getPosition());
    }

    private IntVector2D findTargetInVisionOrNull() {
        BattleField battleField = SimulationManager.getInstance().getBattleField();

        int fromY = this.getPosition().getY() - VISION;
        int fromX = this.getPosition().getX() - VISION;

        int toY = this.getPosition().getY() + VISION;
        int toX = this.getPosition().getX() + VISION;

        for (int y = fromY; y <= toY; y++) {
            for (int x = fromX; x <= toX; x++) {
                if (battleField.isValidPosition(y, x) == false) {
                    continue;
                }

                HashSet<Unit> unitHashSet = battleField.getUnitsFromPosition(y, x);

                for (Unit unit : unitHashSet) {
                    if (unit == this || unit.unitType != EUnitType.GROUND) {
                        continue;
                    }

                    return new IntVector2D(unit.getPosition());
                }
            }
        }

        return null;
    }
}
