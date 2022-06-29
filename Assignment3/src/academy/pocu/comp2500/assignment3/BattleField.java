package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.HashSet;

public class BattleField {
    private ArrayList<ArrayList<HashSet<Unit>>> map;
    public final static int Y_LENGTH = 8;
    public final static int X_LENGTH = 16;

    public BattleField() {
        map = new ArrayList<ArrayList<HashSet<Unit>>>(Y_LENGTH);

        for (int y = 0; y < Y_LENGTH; y++) {
            map.add(new ArrayList<HashSet<Unit>>(X_LENGTH));

            for (int x = 0; x < X_LENGTH; x++) {
                this.map.get(y).add(new HashSet<Unit>());
            }
        }
    }

    public HashSet<Unit> getUnitsFromPosition(final int y, final int x) {
        return this.map.get(y).get(x);
    }

    public void move(final int fromY, final int fromX, final int toY, final int toX, final Unit unit) {
        remove(fromY, fromX, unit);
        add(toY, toX, unit);
    }

    public void add(final int y, final int x, final Unit unit) {
        this.map.get(y).get(x).add(unit);
    }

    public void remove(final int y, final int x, final Unit unit) {
        this.map.get(y).get(x).remove(unit);
    }

    public boolean isValidPosition(int y, int x) {
        return 0 <= y && y < Y_LENGTH && 0 <= x && x < X_LENGTH;
    }

    public void clear() {
        for (int y = 0; y < this.map.size(); y++) {
            for (int x = 0; x < this.map.get(0).size(); x++) {
                this.map.get(y).get(x).clear();
            }
        }
    }
}
