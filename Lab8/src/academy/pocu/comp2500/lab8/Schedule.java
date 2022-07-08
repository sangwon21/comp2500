package academy.pocu.comp2500.lab8;

public class Schedule {
    private int startTick;
    private int endTick;
    private boolean inUse;

    public Schedule(final int startTick, final int durationTime) {
        this.startTick = startTick;
        this.endTick = startTick + durationTime - 1;
    }

    public int getStartTick() {
        return startTick;
    }

    public int getEndTick() {
        return endTick;
    }

    public boolean getInUse() {
        return this.inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
}
