package com.mcmaster.se2op3;

import java.util.List;

public class Quadratics {

    public static List<Double> solveQuadratic(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return List.of();
        }
        double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        return List.of(root1, root2);
    }

    public static boolean validateInput(double a) {
        return a >= -100 && a <= 100;
    }

}
