package academy.pocu.comp2500.lab8;

public class Schedule {
    private int startTick;
    private int endTick;

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
}
