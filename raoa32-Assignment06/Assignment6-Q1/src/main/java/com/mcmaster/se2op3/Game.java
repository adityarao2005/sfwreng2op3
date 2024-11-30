package com.mcmaster.se2op3;

import java.util.Scanner;

/**
 * Manages the state of the game (e.g., game loop, checking for win
 * conditions).
 */
public class Game {
    // Scanner for reading input
    public static Scanner scanner = new Scanner(System.in);
    // The players in the game
    private Player player1;
    private Player player2;
    private Board board;

    public Game() {
    }

    private void initializeGame() {

        // Game modes prompt
        System.out.println("Game Modes: Human vs Human (1), Human vs Computer (2), Computer vs Computer (3)");
        System.out.println("Enter Game Mode (1,2,3):");
        int gameMode = scanner.nextInt();

        // Validate input
        while (gameMode < 1 || gameMode > 3) {
            System.out.println("Invalid input. Please enter 1, 2, or 3: ");
            System.out.println("Game Modes: Human vs Human (1), Human vs Computer (2), Computer vs Computer (3)");
            System.out.println("Enter Game Mode (1,2,3):");
            gameMode = scanner.nextInt();
        }
        // Create the players
        if (gameMode == 1) {
            player1 = new HumanPlayer('X');
            player2 = new HumanPlayer('O');
        } else if (gameMode == 2) {
            player1 = new HumanPlayer('X');
            player2 = new SmartComputerPlayer('O');
        } else {
            player1 = new SmartComputerPlayer('X');
            player2 = new SmartComputerPlayer('O');
        }

        // Create the board
        board = createBoard();

    }

    // Create a new board
    public Board createBoard() {
        return new Board(3, 3);
    }

    public void start() {

        boolean playAgain = false;
        do {
            // Re-initializes the game
            initializeGame();
            // Create a new game
            gameLoop();

            // Ask the user if they want to play again
            System.out.println("Would you like to play again? (Y/N)");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("Y");
        } while (playAgain);
    }

    public void gameLoop() {
        int turns = board.getRows() * board.getColumns();
        board.displayBoard();
        // Game loop
        // Loop as long as we haven't detected a win condition
        while (turns != 0 && !checkWinCondition()) {
            // Player 1's turn
            player1.makeTurn(board);
            // Display the board
            board.displayBoard();

            // Decrement the number of turns
            turns--;
            // Check for win condition
            if (checkWinCondition()) {
                System.out.println("Player 1 wins!");
                return;
            }

            if (turns == 0)
                break;

            // Player 2's turn
            player2.makeTurn(board);
            // Display the board
            board.displayBoard();
            // Decrement the number of turns
            turns--;
            // Check for win condition
            if (checkWinCondition()) {
                System.out.println("Player 2 wins!");
                return;
            }
        }

        // If we've run out of turns, it's a tie
        if (turns == 0) {
            System.out.println("It's a tie!");
        }
    }

    public boolean checkWinCondition() {
        // Check rows
        for (int row = 0; row < board.getRows(); row++) {
            // Check flag
            boolean check = true;

            // Get the first character in the row
            char cc = board.getBoard()[row][0];

            // Check if all the characters in the row are the same and not spaces
            for (int i = 1; i < board.getColumns(); i++) {
                if (cc != board.getBoard()[row][i] || cc == ' ') {
                    check = false;
                    break;
                }
            }

            // If all the characters in the row are the same, return true
            if (check) {
                return true;
            }
        }

        // Check columns
        for (int column = 0; column < board.getColumns(); column++) {
            // Check flag
            boolean check = true;

            // Get the first character in the column
            char cc = board.getBoard()[0][column];

            // Check if all the characters in the column are the same and not spaces
            for (int i = 1; i < board.getColumns(); i++) {
                if (cc != board.getBoard()[i][column] || cc == ' ') {
                    check = false;
                    break;
                }
            }

            // If all the characters in the column are the same, return true
            if (check) {
                return true;
            }
        }

        // Check diagonals
        boolean check = true;
        char cc = board.getBoard()[0][0];
        for (int i = 1; i < board.getRows(); i++) {
            if (cc != board.getBoard()[i][i] || cc == ' ') {
                check = false;
                break;
            }
        }

        if (check) {
            return true;
        }
        check = true;

        cc = board.getBoard()[0][board.getRows() - 1];
        for (int i = 1; i < board.getRows(); i++) {
            if (cc != board.getBoard()[i][board.getRows() - 1 - i] || cc == ' ') {
                check = false;
                break;
            }
        }

        return check;
    }

}
