package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public abstract class Unit {
    protected IntVector2D position;
    protected int hp;
    protected char symbol;
    protected EActionType action;
    protected EUnitType unitType;

    protected Unit(IntVector2D position, int hp, char symbol, EUnitType unitType) {
        this.position = position;
        this.hp = hp;
        this.symbol = symbol;
        this.unitType = unitType;
    }

    public IntVector2D getPosition() {
        return this.position;
    }

    public int getHp() {
        return hp;
    }

    public abstract AttackIntent attack();

    public abstract void onAttacked(int damage);

    public abstract void onSpawn();

    public abstract void onRemove();

    public char getSymbol() {
        return this.symbol;
    }

    protected static IntVector2D[] getVisionOffsets(int vision) {
        ArrayList<IntVector2D> offsets = new ArrayList<>();

        for (int i = 1; i <= vision; i++) {

            // 12시 방향부터 시작
            for (int j = 0; j <= i; j++) {
                offsets.add(new IntVector2D(j, -i));
            }

            // 오른쪽
            for (int j = -i + 1; j <= i; j++) {
                offsets.add(new IntVector2D(i, j));
            }

            // 아래쪽
            for (int j = i - 1; j >= -i; j--) {
                offsets.add(new IntVector2D(j, i));
            }

            // 왼쪽
            for (int j = i - 1; j >= -i; j--) {
                offsets.add(new IntVector2D(-i, j));
            }

            // 위쪽 나머지
            for (int j = -i + 1; j < 0; j++) {
                offsets.add(new IntVector2D(j, -i));
            }
        }

        return offsets.toArray(new IntVector2D[0]);
    }

    public int getDistanceFrom(Unit unit) {
        return Math.max(Math.abs(this.position.getY() - unit.position.getY()), Math.abs(this.position.getX() - unit.position.getX()));
    }
}