package com.mcmaster.se2op3;

public class UpgradedGame extends Game {

    @Override
    public Board createBoard() {
        System.out.println("Enter the number of rows and columns for the board (3-20 inclusive):");
        int rows = scanner.nextInt();

        // Validate input
        while (rows < 3 || rows > 20) {
            System.out.println("Invalid input. Please enter a number between 3 and 20 inclusive: ");
            System.out.println("Enter the number of rows and columns for the board (3-20 inclusive):");
            rows = scanner.nextInt();
        }

        return new Board(rows, rows);
    }
}
