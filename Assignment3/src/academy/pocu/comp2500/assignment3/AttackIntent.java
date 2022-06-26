package academy.pocu.comp2500.assignment3;

import java.util.HashSet;

public class AttackIntent {
    private Unit attacker;
    private int y;
    private int x;
    private int ap;
    private int areaOfEffect;
    EUnitType[] possibleAttackUnitTypes;
    private boolean selfAttack;

    public AttackIntent(Unit attacker, int y, int x, int ap, int areaOfEffect, EUnitType[] possibleAttackUnitTypes) {
        this.attacker = attacker;
        this.y = y;
        this.x = x;
        this.ap = ap;
        this.areaOfEffect = areaOfEffect;
        this.possibleAttackUnitTypes = possibleAttackUnitTypes;
    }

    public void inflict() {
        final int fromY = y - this.areaOfEffect;
        final int fromX = x - this.areaOfEffect;

        final int toY = y + this.areaOfEffect;
        final int toX = x + this.areaOfEffect;

        BattleField battleField = SimulationManager.getInstance().getBattleField();

        for (int y = fromY; y <= toY; y++) {
            for (int x = fromX; x <= toX; x++) {
                if (battleField.isValidPosition(y, x) == false) {
                    continue;
                }

                HashSet<Unit> units = battleField.getUnitsFromPosition(y, x);

                for (Unit unit : units) {
                    if (unit == attacker && this.selfAttack == false) {
                        continue;
                    }

                    for (EUnitType unitType : this.possibleAttackUnitTypes) {
                        if (unitType == unit.unitType) {
                            unit.onAttacked(1);
                        }
                    }
                }
            }
        }
    }

    // (공격 지점에서의 피해치) * (1 - 공격 지점으로부터의 거리 / (공격의 AoE 값 + 1))
    private int calculateDamage(Unit unit) {
        int unitY = unit.getPosition().getY();
        int unitX = unit.getPosition().getX();

        int distance = Math.max(Math.abs(unitY - this.y), Math.abs(unitX - this.x));

        int damage = (int) ((double) this.ap * (1.0 - distance / ((double) this.areaOfEffect + 1.0)));

        return damage;
    }
}
