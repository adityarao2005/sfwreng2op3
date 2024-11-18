package com.mcmaster.se2op3;

public class ElectricCar extends Car {
    private float batteryCapacity;
    private float milesPerKWh;

    public ElectricCar() {
        super();
    }

    public ElectricCar(String make, String model, float batteryCapacity, float milesPerKWh) {
        super(make, model);
        this.batteryCapacity = batteryCapacity;
        this.milesPerKWh = milesPerKWh;
    }

    public float getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(float batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public float getMilesPerKWh() {
        return milesPerKWh;
    }

    public void setMilesPerKWh(float milesPerKWh) {
        this.milesPerKWh = milesPerKWh;
    }

    @Override
    public float getFuelEfficiency() {
        return milesPerKWh;
    }

    @Override
    public int getRange() {
        return (int) (batteryCapacity * milesPerKWh);
    }

}
