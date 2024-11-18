package com.mcmaster.se2op3;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a positive integer: ");
        int number = input.nextInt();

        if (number < 1 || number > 200) {
            System.out.println("Integer must be bounded by the following rule: 1<=n<=200.");
            input.close();
            return;
        }

        PatternGenerator.createTriangle(number);

        input.close();
    }
}
