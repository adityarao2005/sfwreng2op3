package com.mcmaster.se2op3;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            cars.add(new GasPoweredCar("Gas Powered Car", "Model " + (i + 1), 100 + i, 100 + i));
        }

        for (int i = 0; i < 10; i++) {
            cars.add(new ElectricCar("Electric Car", "Model " + (i + 1), 100 + i, 100 + i));
        }

        for (int i = 0; i < 10; i++) {
            cars.add(new LuxurySedan("Luxury Sedan", "Model " + (i + 1), 100 + i, 100 + i, 22, "Song " + (i + 1)));
        }

        for (Car car : cars) {
            System.out.printf("Car: %s, Model: %s, Range: %d, Efficiency: %.2f\n", car.getMake(), car.getModel(),
                    car.getRange(), car.getFuelEfficiency());
        }
    }
}
