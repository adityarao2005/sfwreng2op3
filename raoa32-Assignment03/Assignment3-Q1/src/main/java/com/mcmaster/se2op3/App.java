package com.mcmaster.se2op3;

import java.util.Scanner;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the coefficients of the quadratic equation");
        System.out.print("a: ");
        double a = input.nextDouble();
        System.out.print("b: ");
        double b = input.nextDouble();
        System.out.print("c: ");
        double c = input.nextDouble();

        if (Quadratics.validateInput(a) && Quadratics.validateInput(b) && Quadratics.validateInput(c)) {

            List<Double> solutions = Quadratics.solveQuadratic(a, b, c);
            if (solutions.isEmpty()) {
                System.out.println("The equation has no real roots.");
            } else {
                System.out.printf("For a=%.02f, b=%.02f and c=%.02f, the roots are %.02f and %.02f%n", a, b, c,
                        solutions.get(0), solutions.get(1));
            }
        } else {
            System.out.println("Invalid input. Coefficients a, b, and c must be between -100 and 100.");
        }

        input.close();
    }
}
