package com.mcmaster.se2op3;

public class GasPoweredCar extends Car implements Refuelable {
    private float fuelTankCapacity;
    private float milesPerGallon;

    public GasPoweredCar() {
        super();
    }

    public GasPoweredCar(String make, String model, float fuelTankCapacity, float milesPerGallon) {
        super(make, model);
        this.fuelTankCapacity = fuelTankCapacity;
        this.milesPerGallon = milesPerGallon;
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

    @Override
    public float getFuelEfficiency() {
        return milesPerGallon;
    }

    @Override
    public int getRange() {
        return (int) (fuelTankCapacity * milesPerGallon);
    }

    @Override
    public void refuel(float amount) {
        fuelTankCapacity += amount;
    }
    
}
