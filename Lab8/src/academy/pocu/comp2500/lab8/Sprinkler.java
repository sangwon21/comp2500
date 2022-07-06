package academy.pocu.comp2500.lab8;

import java.util.ArrayList;
import java.util.List;

public class Sprinkler extends SmartDevice implements ISprayable {
    private List<Schedule> schedules;
    private Schedule currentScheduleOrNull;

    public Sprinkler() {
        this.schedules = new ArrayList<>();
    }

    public void addSchedule(Schedule schedule) {
        if (schedule.getStartTick() == 0 || schedule.getEndTick() < currentTick) {
            return;
        }

        this.schedules.add(schedule);
    }

    private boolean isValidSchedule(Schedule schedule) {
        return schedule.getEndTick() >= this.currentTick;
    }

    @Override
    public void onTick() {
        this.currentTick++;

        if (currentScheduleOrNull != null && isValidSchedule(currentScheduleOrNull) == true) {
            setOn(true);

            return;
        }

        // currentScheduleOrNull null or isValidSchedule true
        while (this.schedules.size() > 0) {
            if (this.currentScheduleOrNull != null && this.currentScheduleOrNull.getEndTick() == currentTick - 1) {
                this.setOn(false);
                this.currentScheduleOrNull = null;
                return;
            }

            if (this.schedules.get(0).getStartTick() < currentTick) {
                this.schedules.remove(0);
                continue;
            }

            if (this.schedules.get(0).getStartTick() == currentTick) {
                this.currentScheduleOrNull = this.schedules.get(0);
                this.schedules.remove(0);
                this.setOn(true);
                return;
            }

            if (this.schedules.get(0).getStartTick() > currentTick) {
                setOn(false);
                return;
            }
        }

        if (currentScheduleOrNull == null) {
            setOn(false);
            return;
        }

        if (isValidSchedule(currentScheduleOrNull)) {
            if (currentScheduleOrNull.getStartTick() == this.currentTick) {
                setOn(true);
                return;
            }
        }

        setOn(false);
    }


    @Override
    public void onInstall(Planter planter) {
        planter.registerISprayable(this);
    }

    @Override
    public void spray(Planter planter) {
        if (this.on) {
            planter.sprayTo(15);
        }
    }
}
