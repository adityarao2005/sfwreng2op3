package com.mcmaster.se2op3;

public abstract class Car {
    private String make;
    private String model;

    public Car() {
    }

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public abstract float getFuelEfficiency();

    public abstract int getRange();
}
