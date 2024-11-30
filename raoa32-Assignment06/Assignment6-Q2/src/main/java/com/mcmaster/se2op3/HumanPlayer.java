package com.mcmaster.se2op3;

import static com.mcmaster.se2op3.Game.scanner;

// Represents a human player in the Tic-Tac-Toe game
public class HumanPlayer extends Player {

    public HumanPlayer(char symbol) {
        super(symbol);
    }

    @Override
    public void makeTurn(Board board) {
        // Prompt for row and column
        System.out.printf("Player %c: Enter row and column (1-3): \n", getSymbol());
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        // Check if the move is valid
        while (!board.isValidMove(row, col)) {
            System.out.println("Invalid move. Enter row and column (1-3): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        }

        // Claim the square
        board.claimSquare(row, col, getSymbol());
    }
}
