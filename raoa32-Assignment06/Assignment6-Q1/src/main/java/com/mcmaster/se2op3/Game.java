package com.mcmaster.se2op3;

import java.util.Scanner;

/**
 * Manages the state of the game (e.g., game loop, checking for win
 * conditions).
 */
public class Game {
    public static Scanner scanner = new Scanner(System.in);
    private Player player1;
    private Player player2;
    private Board board;

    public Game() {
        // Welcome message
        System.out.println("Welcome to Tic-Tac-Toe!");

        // Create the players
        player1 = createPlayer('X');
        player2 = createPlayer('O');
        board = new Board();
    }

    // Create a player based on user input
    private Player createPlayer(char symbol) {
        // Ask the user if they want to be a human or computer player
        System.out.printf("Player %c, Enter whether you want to be a human (H) or computer (C): \n", symbol);
        // Read the user's input
        String playerType = scanner.nextLine();
        // Validate the input
        while (!playerType.equalsIgnoreCase("H") && !playerType.equalsIgnoreCase("C")) {
            System.out.println("Invalid input. Please enter H for human or C for computer: ");
            playerType = scanner.nextLine();
        }

        // Create the player based on the input
        if (playerType.equalsIgnoreCase("H")) {
            return new HumanPlayer(symbol);
        } else {
            return new ComputerPlayer(symbol);
        }
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
                break;
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
                break;
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
            if (board.getBoard()[row][0] == board.getBoard()[row][1]
                    && board.getBoard()[row][1] == board.getBoard()[row][2]
                    && board.getBoard()[row][0] != ' ') {
                return true;
            }
        }

        // Check columns
        for (int column = 0; column < board.getColumns(); column++) {
            if (board.getBoard()[0][column] == board.getBoard()[1][column]
                    && board.getBoard()[1][column] == board.getBoard()[2][column]
                    && board.getBoard()[0][column] != ' ') {
                return true;
            }
        }

        // Check diagonals
        if (board.getBoard()[0][0] == board.getBoard()[1][1] && board.getBoard()[1][1] == board.getBoard()[2][2]
                && board.getBoard()[0][0] != ' ') {
            return true;
        }

        if (board.getBoard()[0][2] == board.getBoard()[1][1] && board.getBoard()[1][1] == board.getBoard()[2][0]
                && board.getBoard()[0][2] != ' ') {
            return true;
        }

        return false;
    }

}
