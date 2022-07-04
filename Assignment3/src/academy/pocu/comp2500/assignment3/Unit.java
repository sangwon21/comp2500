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

        for (int x = 0; x <= vision; x++) {
            for (int y = -1; y >= -vision; y--) {
                offsets.add(new IntVector2D(x, y));
            }
        }

        for (int y = 0; y <= vision; y++) {
            for (int x = 1; x <= vision; x++) {
                offsets.add(new IntVector2D(x, y));
            }
        }

        for (int x = 0; x >= -vision; x--) {
            for (int y = 1; y <= vision; y++) {
                offsets.add(new IntVector2D(x, y));
            }
        }

        for (int y = 0; y >= -vision; y--) {
            for (int x = -1; x >= -vision; x--) {
                offsets.add(new IntVector2D(x, y));
            }
        }

        return offsets.toArray(new IntVector2D[0]);
    }

    public int getDistanceFrom(Unit unit) {
        return Math.max(Math.abs(this.position.getY() - unit.position.getY()), Math.abs(this.position.getX() - unit.position.getX()));
    }

    public int getManhattanDistanceFrom(Unit unit) {
        return Math.abs(this.position.getY() - unit.position.getY()) + Math.abs(this.position.getX() - unit.position.getX());
    }

}