package academy.pocu.comp2500.assignment3;

public class Destroyer extends Unit {
    private static final EUnitType UNIT_TYPE = EUnitType.AIR;
    private static final int AREA_OF_EFFECT = 16;
    private static final int AP = 100000;
    private static final int HP = 100000;
    private static final EUnitType[] POSSIBLE_ATTACK_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR, EUnitType.INVISIBLE};


    public Destroyer(final IntVector2D position) {
        super(position, HP, Symbol.Destroyer, UNIT_TYPE);
    }

    @Override
    public void onSpawn() {
    }

    @Override
    public void onRemove() {
    }

    @Override
    public AttackIntent attack() {

        return new AttackIntent(this, this.position.getY(), this.position.getX(), AP, AREA_OF_EFFECT, POSSIBLE_ATTACK_UNIT_TYPES, false);
    }

    @Override
    public void onAttacked(int damage) {
        this.hp -= 1;
    }
}
