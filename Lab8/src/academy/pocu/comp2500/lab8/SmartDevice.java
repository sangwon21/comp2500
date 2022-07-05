package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    protected int currentTick;
    protected int lastUpdatedTick;
    protected boolean on;

    protected SmartDevice() {
        currentTick = 0;
        this.on = false;
    }

    public abstract void onInstall(Planter planter);

    public void onTick() {
        this.currentTick++;
    }

    public void setOn(boolean on) {
        if (this.on != on) {
            this.lastUpdatedTick = this.currentTick;
        }

        this.on = on;
    }

    public int getTicksSinceLastUpdate() {
        return this.currentTick - this.lastUpdatedTick;
    }

    public boolean isOn() {
        return this.on;
    }
}
