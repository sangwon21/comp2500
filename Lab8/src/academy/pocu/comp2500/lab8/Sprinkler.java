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

        while (this.schedules.size() > 0 && (currentScheduleOrNull == null || isValidSchedule(currentScheduleOrNull) == false)) {
            if (currentScheduleOrNull != null && currentScheduleOrNull.getEndTick() == currentTick) {
                this.setOn(false);

                currentScheduleOrNull = null;
                return;
            }

            currentScheduleOrNull = null;
            if (isValidSchedule(this.schedules.get(0)) == false) {
                schedules.remove(0);
                continue;
            }

            if (this.schedules.get(0).getStartTick() > currentTick) {
                this.on = false;
                return;
            }

            currentScheduleOrNull = schedules.get(0);
            schedules.remove(0);
            break;
        }

        if (currentScheduleOrNull == null) {
            setOn(false);
            return;
        }

        if (isValidSchedule(currentScheduleOrNull)) {
            if (currentScheduleOrNull.getStartTick() <= this.currentTick) {
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
