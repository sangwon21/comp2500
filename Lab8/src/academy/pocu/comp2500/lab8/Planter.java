package academy.pocu.comp2500.lab8;

import java.util.ArrayList;
import java.util.List;

public class Planter {
    private int remainWater;
    private List<SmartDevice> smartDevices;
    private List<IDrainable> iDrainables;
    private List<ISprayable> iSprayables;
    private List<IWaterDetectable> iWaterDetectables;

    public Planter(final int remainWater) {
        this.remainWater = remainWater;
        this.smartDevices = new ArrayList<>();
        this.iDrainables = new ArrayList<>();
        this.iSprayables = new ArrayList<>();
        this.iWaterDetectables = new ArrayList<>();
    }

    public int getWaterAmount() {
        return this.remainWater;
    }

    public void installSmartDevice(SmartDevice smartDevice) {
        this.smartDevices.add(smartDevice);
        smartDevice.onInstall(this);
    }

    public void registerIDrainables(IDrainable iDrainable) {
        this.iDrainables.add(iDrainable);
    }

    public void registerISprayable(ISprayable iSprayable) {
        this.iSprayables.add(iSprayable);
    }

    public void registerIWaterDetectable(IWaterDetectable iWaterDetectable) {
        this.iWaterDetectables.add(iWaterDetectable);
    }

    public void tick() {
        for (SmartDevice smartDevice : this.smartDevices) {
            smartDevice.onTick();
        }

        for (IWaterDetectable waterDetectable : this.iWaterDetectables) {
            waterDetectable.detect(this.remainWater);
        }

        for (ISprayable iSprayable : this.iSprayables) {
            iSprayable.spray(this);
        }

        for (IDrainable iDrainable : this.iDrainables) {
            iDrainable.drain(this);
        }
       
        drainedTo(2);
    }

    public void drainedTo(int water) {
        this.remainWater -= water;
        this.remainWater = Math.max(this.remainWater, 0);
    }

    public void sprayTo(int water) {
        this.remainWater += water;
    }
}
