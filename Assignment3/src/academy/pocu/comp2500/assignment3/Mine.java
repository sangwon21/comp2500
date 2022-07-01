package academy.pocu.comp2500.assignment3;

public class Mine extends Unit implements ICollidable {
    private static final int AREA_OF_EFFECT = 0;
    private static final int AP = 10;
    private static final int HP = 1;
    private static final EUnitType[] POSSIBLE_ATTACK_UNIT_TYPES = {EUnitType.GROUND, EUnitType.INVISIBLE};
    private int threshold;


    public Mine(IntVector2D position, int threshold) {
        super(position, HP, Symbol.MINE, EUnitType.GROUND);
        this.threshold = threshold;
    }

    protected Mine(IntVector2D position, int threshold, char symbol) {
        super(position, HP, symbol, EUnitType.GROUND);
        this.threshold = threshold;
    }

    @Override
    public void onSpawn() {
        SimulationManager.getInstance().registerCollisionEventListener(this);
    }

    @Override
    public void onRemove() {
        SimulationManager.getInstance().removeCollisionEventListener(this);
    }

    @Override
    public void collide(Unit unit) {
//        System.out.println(String.format("collided units are %c ", unit.getSymbol()));
//        System.out.println(String.format("collided units are %s ", unit.unitType));
        if (unit == this || unit.unitType == EUnitType.AIR) {
            return;
        }
//        System.out.println(" +++++++++++++++++++++ ");
//        System.out.println(String.format("this equals? %s", this == unit));
//        System.out.println(String.format("collided units are %c ", unit.getSymbol()));
//        System.out.println(String.format("collided units are %s ", unit.unitType));
//        System.out.println(("+++++++++++++++++++++++++++"));
        if (unit.unitType == EUnitType.INVISIBLE) {
            this.threshold -= 1;
        }

        this.threshold -= 1;
    }

    @Override
    public AttackIntent attack() {
//        System.out.println(String.format("Mine threshold %d", this.threshold));
        if (this.threshold > 0) {
            return null;
        }

        return new AttackIntent(this, this.position.getY(), this.position.getX(), AP, AREA_OF_EFFECT, POSSIBLE_ATTACK_UNIT_TYPES, true);
    }

    @Override
    public void onAttacked(int damage) {
        this.hp -= damage;
    }
}
