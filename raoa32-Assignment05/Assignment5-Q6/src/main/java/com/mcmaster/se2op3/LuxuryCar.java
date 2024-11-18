package com.mcmaster.se2op3;

public abstract class LuxuryCar extends GasPoweredCar {
    private float temperature;

    public LuxuryCar() {
    }

    public LuxuryCar(String make, String model, float fuelTankCapacity, float milesPerGallon, float temperature) {
        super(make, model, fuelTankCapacity, milesPerGallon);
        this.temperature = temperature;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public abstract void playMedia(String song);
}
