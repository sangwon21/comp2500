package academy.pocu.comp2500.lab8;

public class Drainer extends SmartDevice implements IDrainable, IWaterDetectable {
    private int threshold;
    private static final int WATER_PER_TICK = 7;

    public Drainer(final int threshold) {
        this.threshold = threshold;
    }

    @Override
    public void onInstall(Planter planter) {
        planter.registerIDrainables(this);
        planter.registerIWaterDetectable(this);
    }

    @Override
    public void drain(Planter planter) {
        if (this.on) {
            planter.drainedTo(WATER_PER_TICK);
        }
    }

    @Override
    public void detect(final int waterLevel) {
        setOn(waterLevel >= this.threshold);
    }
}
