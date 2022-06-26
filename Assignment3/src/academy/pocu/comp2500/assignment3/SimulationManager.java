package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.HashSet;

public final class SimulationManager {
    private BattleField battleField;
    private ArrayList<IMovable> movables;
    private ArrayList<IThinkable> thinkables;
    private ArrayList<ICollidable> collidables;
    private static SimulationManager instance;
    private ArrayList<AttackIntent> attackIntents;
    private ArrayList<Unit> attackedUnit;

    private SimulationManager() {
        this.battleField = new BattleField();
        this.movables = new ArrayList<>();
        this.thinkables = new ArrayList<>();
        this.collidables = new ArrayList<>();
    }

    public static SimulationManager getInstance() {
        if (instance == null) {
            instance = new SimulationManager();
            return instance;
        }

        return instance;
    }

    public BattleField getBattleField() {
        return this.battleField;
    }

    public ArrayList<Unit> getUnits() {
        return null;
    }

    public void spawn(Unit unit) {
        unit.onSpawn();
    }

    public void registerThinkable(IThinkable thinkable) {
        this.thinkables.add(thinkable);
    }

    public void registerMovable(IMovable movable) {
        this.movables.add(movable);
    }

    public void registerCollisionEventListener(ICollidable listener) {
        collidables.add(listener);
    }

    public void update() {
        for (IThinkable thinkable : thinkables) {
            thinkable.think();
        }

        for (IMovable movable : movables) {
            movable.move();
        }

        for (ICollidable iCollidable : collidables) {

        }

        for (int y = 0; y < BattleField.Y_LENGTH; y++) {
            for (int x = 0; x < BattleField.X_LENGTH; x++) {
                HashSet<Unit> units = this.battleField.getUnitsFromPosition(y, x);

                for (Unit unit : units) {
                    AttackIntent attackIntent = unit.attack();

                    if (attackIntent != null) {
                        this.attackIntents.add(attackIntent);
                    }
                }
            }
        }

        for (AttackIntent attackIntent : this.attackIntents) {
            attackIntent.inflict();
        }

    }
}
