package com.mcmaster.se2op3;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
	// Create a scanner to read the user input
        Scanner scanner = new Scanner(System.in);
	// declare the radius variable
        double radius;

	// Prompt the user to enter the radius between values 0 and 10
        System.out.println("Enter the radius of a circle with the value between 0.0 and 10.0:");
	// Get the user input in the value of a float
        radius = scanner.nextDouble();

	// Check if the radius is a valid value
        if (radius <= 0.0 || radius > 10.0) {
		// If the input is invalid. Display an error message and exit
		System.out.println("Invalid input. The radius must be greater than 0.0 and less than or equal to 10.0.");
	} else {
		// Create the radius and circumference from the radius
		double area = Math.PI * Math.pow(radius, 2);
		double circumference = 2 * Math.PI * radius;
		
		// Format the area and circumference to 2 decimal places and display the values
		System.out.printf("The area of the circle is: %.2f%n", area);
		System.out.printf("The circumference of the circle is %.2f%n", circumference);
        }

	// Close the scanners
        scanner.close();
    }
}
