package com.mcmaster.se2op3;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Create a scanner object
        Scanner input = new Scanner(System.in);

        // Ask the user for a number
        System.out.println("Enter a decimal number for conversion:");
        int number = input.nextInt();

        // Check if the number is within the range
        if (number < -1000 || number > 1000) {
            // Print an error message and exit
            System.out.println("Input numbers must be obeying the following the following rule: -1000<=x<=1000.");
            input.close();
            return;
        }

        // Convert the number to octal
        System.out.printf("Octal value: %d%n", DecimalToConversion.toOctal(number));

        input.close();
    }
}
