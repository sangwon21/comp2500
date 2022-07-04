package academy.pocu.comp2500.assignment3;

import java.util.HashSet;
import java.util.Set;

public class AttackIntent {
    private Unit attacker;
    private int y;
    private int x;
    private int ap;
    private int areaOfEffect;
    EUnitType[] possibleAttackUnitTypes;
    private boolean selfAttack;

    public AttackIntent(final Unit attacker, final int y, final int x, final int ap, final int areaOfEffect, final EUnitType[] possibleAttackUnitTypes, final boolean selfAttack) {
        this.attacker = attacker;
        this.y = y;
        this.x = x;
        this.ap = ap;
        this.areaOfEffect = areaOfEffect;
        this.possibleAttackUnitTypes = possibleAttackUnitTypes;
        this.selfAttack = selfAttack;
    }

    public AttackIntent(final AttackIntent other, final int ap, final int areaOfEffect) {
        this.attacker = other.attacker;
        this.y = other.y;
        this.x = other.x;
        this.ap = ap;
        this.areaOfEffect = areaOfEffect;
        this.possibleAttackUnitTypes = other.possibleAttackUnitTypes;
        this.selfAttack = other.selfAttack;
    }

    public void inflict(final Set<Unit> attackedUnits) {
        final int fromY = this.y - this.areaOfEffect;
        final int fromX = this.x - this.areaOfEffect;

        final int toY = this.y + this.areaOfEffect;
        final int toX = this.x + this.areaOfEffect;

        BattleField battleField = SimulationManager.getInstance().getBattleField();

        if (battleField.isValidPosition(this.y, this.x) == false) {
            return;
        }

        for (int y = fromY; y <= toY; y++) {
            for (int x = fromX; x <= toX; x++) {
                if (battleField.isValidPosition(y, x) == false) {
                    continue;
                }

                HashSet<Unit> units = battleField.getUnitsFromPosition(y, x);

                for (Unit unit : units) {
                    if (unit == this.attacker && this.selfAttack == false) {
                        continue;
                    }

                    for (EUnitType unitType : this.possibleAttackUnitTypes) {
                        if (unitType == unit.unitType) {
                            unit.onAttacked(calculateDamage(y, x));
                            attackedUnits.add(unit);
                            continue;
                        }
                    }
                }
            }
        }
    }

    private int calculateDamage(final int unitY, final int unitX) {

        int distance = Math.max(Math.abs(unitY - this.y), Math.abs(unitX - this.x));

        int damage = (int) ((double) this.ap * (1.0 - distance / ((double) this.areaOfEffect + 1.0)));
        
        return damage;
    }
}
