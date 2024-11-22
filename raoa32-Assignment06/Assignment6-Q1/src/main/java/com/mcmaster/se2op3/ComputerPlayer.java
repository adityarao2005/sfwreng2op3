package com.mcmaster.se2op3;

// Represents a computer player in the Tic-Tac-Toe game
public class ComputerPlayer extends Player {

    public ComputerPlayer(char symbol) {
        super(symbol);
    }

    @Override
    public void makeTurn(Board board) {
        // Prompt for row and column
        System.out.printf("Player %c is thinking.\n", getSymbol());
        int row = (int) Math.round(Math.random() * 2 + 1);
        int col = (int) Math.round(Math.random() * 2 + 1);

        // Check if the move is valid
        while (!board.isValidMove(row, col)) {
            System.out.println("Invalid move. Enter row and column (1-3): ");
            row = (int) (Math.random() * 2 + 1);
            col = (int) (Math.random() * 2 + 1);
        }

        // Claim the square
        board.claimSquare(row, col, getSymbol());
    }
}
