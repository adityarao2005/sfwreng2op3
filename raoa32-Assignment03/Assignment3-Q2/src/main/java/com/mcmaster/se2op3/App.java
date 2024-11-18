package com.mcmaster.se2op3;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the input from the user
        System.out.println("Enter a telephone number:");
        String number = input.nextLine();

        // Validate phone number
        if (TelephoneMapper.validateFormat(number)) {
            // Map the number
            String mappedNumber = TelephoneMapper.mapNumber(number);

            // Output the mapped number
            System.out.printf("The phone number for %s is %s.%n", number, mappedNumber);
        } else {
            System.out.println("Invalid phone number format.");
        }

        input.close();
    }
}
