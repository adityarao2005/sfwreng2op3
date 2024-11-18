package com.mcmaster.se2op3;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Get user input
        Scanner input = new Scanner(System.in);

        // Get user input
        System.out.println("Enter a positive integer: ");
        int number = input.nextInt();

        // Validate input
        if (number < 1 || number > 200) {
            System.out.println("Integer must be bounded by the following rule: 1<=n<=200.");
            input.close();
            return;
        }

        // Create a new instance of the DivisibleNumbers class
        DivisibleNumbers divisibleNumbers = new DivisibleNumbers();

        // Find the numbers that are divisible by 3, 5, and 15
        divisibleNumbers.findDivisibleNumbers(number);

        // Print the results
        System.out.printf("Divisible by 3 -> %s.", divisibleNumbers.getDivideByThree());
        System.out.printf("Divisible by 5 -> %s.", divisibleNumbers.getDivideByFive());
        System.out.printf("Divisible by 3 and 5 -> %s.", divisibleNumbers.getDivideByFifteen());

        // Close the scanner
        input.close();
    }
}
