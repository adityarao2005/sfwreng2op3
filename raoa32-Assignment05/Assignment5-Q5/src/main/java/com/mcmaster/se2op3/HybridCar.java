package com.mcmaster.se2op3;

public class HybridCar extends Car {
    private float fuelTankCapacity;
    private float milesPerGallon;
    private float batteryCapacity;
    private float milesPerKWh;

    public HybridCar() {
        super();
    }

    public HybridCar(String make, String model, float fuelTankCapacity, float milesPerGallon, float batteryCapacity,
            float milesPerKWh) {
        super(make, model);
        this.fuelTankCapacity = fuelTankCapacity;
        this.milesPerGallon = milesPerGallon;
        this.batteryCapacity = batteryCapacity;
        this.milesPerKWh = milesPerKWh;
    }

    public HybridCar(String make, String model, float capacity, float milesPerAmount, boolean battery) {
        super(make, model);
        if (battery) {
            this.batteryCapacity = capacity;
            this.milesPerKWh = milesPerAmount;
        } else {
            this.fuelTankCapacity = capacity;
            this.milesPerGallon = milesPerAmount;
        }
    }

    public float getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(float fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public float getMilesPerGallon() {
        return milesPerGallon;
    }

    public void setMilesPerGallon(float milesPerGallon) {
        this.milesPerGallon = milesPerGallon;
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
        return (milesPerGallon + milesPerKWh) / 2;
    }

    @Override
    public int getRange() {
        return (int) ((fuelTankCapacity * milesPerGallon) + (batteryCapacity * milesPerKWh));
    }

}
