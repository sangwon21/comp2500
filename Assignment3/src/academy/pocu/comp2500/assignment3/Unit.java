package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public abstract class Unit {
    protected IntVector2D position;
    protected int hp;
    protected char symbol;
    protected EActionType action;
    protected EUnitType unitType;
    protected IntVector2D[] vision;
    protected IntVector2D[] areaOfEffect;


    private final static IntVector2D[] RANGE_1 = {
            new IntVector2D(-1, 0),
            new IntVector2D(1, 1),
            new IntVector2D(0, 1),
            new IntVector2D(-1, 1),
            new IntVector2D(-1, 0),
            new IntVector2D(-1, -1),
            new IntVector2D(0, -1),
            new IntVector2D(1, -1),

    };

    private final static IntVector2D[] RANGE_2 = {
            new IntVector2D(-1, 0),
            new IntVector2D(1, 1),
            new IntVector2D(0, 1),
            new IntVector2D(-1, 1),
            new IntVector2D(-1, 0),
            new IntVector2D(-1, -1),
            new IntVector2D(0, -1),
            new IntVector2D(1, -1),
            new IntVector2D(-2, 0),
            new IntVector2D(-2, 1),
            new IntVector2D(-2, 2),
            new IntVector2D(-1, 2),
            new IntVector2D(0, 2),
            new IntVector2D(-1, 2),
            new IntVector2D(-2, 2),
            new IntVector2D(-2, 1),
            new IntVector2D(-2, 0),
            new IntVector2D(-2, -1),
            new IntVector2D(-2, -2),
            new IntVector2D(-1, -2),
            new IntVector2D(0, -2),
            new IntVector2D(1, -2),
            new IntVector2D(2, -2),
            new IntVector2D(2, -1)
    };

    private final static IntVector2D[] RANGE_3 = {
            new IntVector2D(-1, 0),
            new IntVector2D(1, 1),
            new IntVector2D(0, 1),
            new IntVector2D(-1, 1),
            new IntVector2D(-1, 0),
            new IntVector2D(-1, -1),
            new IntVector2D(0, -1),
            new IntVector2D(1, -1),
            new IntVector2D(-2, 0),
            new IntVector2D(-2, 1),
            new IntVector2D(-2, 2),
            new IntVector2D(-1, 2),
            new IntVector2D(0, 2),
            new IntVector2D(-1, 2),
            new IntVector2D(-2, 2),
            new IntVector2D(-2, 1),
            new IntVector2D(-2, 0),
            new IntVector2D(-2, -1),
            new IntVector2D(-2, -2),
            new IntVector2D(-1, -2),
            new IntVector2D(0, -2),
            new IntVector2D(1, -2),
            new IntVector2D(2, -2),
            new IntVector2D(2, -1),
            new IntVector2D(3, 0),
            new IntVector2D(3, 1),
            new IntVector2D(3, 2),
            new IntVector2D(3, 3),
            new IntVector2D(2, 3),
            new IntVector2D(1, 3),
            new IntVector2D(0, 3),
            new IntVector2D(-1, 3),
            new IntVector2D(-2, 3),
            new IntVector2D(-3, 3),
            new IntVector2D(-3, 2),
            new IntVector2D(-3, 1),
            new IntVector2D(-3, 0),
            new IntVector2D(-3, -1),
            new IntVector2D(-3, -2),
            new IntVector2D(-3, -3),
            new IntVector2D(-2, -3),
            new IntVector2D(-1, -3),
            new IntVector2D(0, -3),
            new IntVector2D(1, -3),
            new IntVector2D(2, -3),
            new IntVector2D(3, -3),
            new IntVector2D(3, -2),
            new IntVector2D(3, -1)
    };


    protected Unit(IntVector2D position, int hp, char symbol, EUnitType unitType) {
        this.position = position;
        this.hp = hp;
        this.symbol = symbol;
        this.unitType = unitType;
    }

    public IntVector2D getPosition() {
        return null;
    }

    public int getHp() {
        return -1;
    }

    public AttackIntent attack() {
        return null;
    }

    public void onAttacked(int damage) {

    }

    public void onSpawn() {

    }

    public char getSymbol() {
        return ' ';
    }

    protected static IntVector2D[] getVisionOffsets(int vision) {
        ArrayList<IntVector2D> offsets = new ArrayList<>();

        for (int i = 1; i <= vision; i++) {

            // 12시 방향부터 시작
            for (int j = 0; j <= i; j++) {
                offsets.add(new IntVector2D(i, j));
            }

            // 오른쪽
            for (int j = i - 1; j >= -i; j--) {
                offsets.add(new IntVector2D(j, i));
            }

            // 아래쪽
            for (int j = i - 1; j >= -i; j--) {
                offsets.add(new IntVector2D(-i, j));
            }

            // 왼쪽
            for (int j = -i + 1; j <= i; j++) {
                offsets.add(new IntVector2D(j, -i));
            }

            // 위쪽 나머지
            for (int j = -i; j < 0; j++) {
                offsets.add(new IntVector2D(i, j));
            }
        }

        return offsets.toArray(new IntVector2D[0]);
    }
}