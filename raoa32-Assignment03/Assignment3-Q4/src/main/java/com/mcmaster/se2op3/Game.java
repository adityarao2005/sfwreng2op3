package com.mcmaster.se2op3;

import java.util.Scanner;

public class Game {

    public void run() {
        // Create a new game
        Scanner input = new Scanner(System.in);

        int y = (int) Math.round(Math.random() * Math.pow(2, 10));
        System.out.println(
                "Random number has been selected and is between 0 and 1024. You have 10 chances to guess the number.");
        boolean guessed = false;

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter your guess: ");
            int number = input.nextInt();

            if (number == y) {
                System.out.println("You successfully guessed the number!");
                guessed = true;
                break;
            } else if (y < number) {
                System.out.printf("The number is lower than %s.%n", number);
            } else {
                System.out.printf("The number is higher than %s.%n", number);
            }
        }

        if (!guessed) {
            System.out.println("You have exhausted your trials.");
        }

        input.close();
    }
}
