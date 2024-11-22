package com.mcmaster.se2op3;

/**
 * Manages the Tic-Tac-Toe grid, including placing markers and displaying
 * the board.
 */
public class Board {
    private char[][] board;

    public Board() {
        board = new char[3][3];

        // Initialize the board with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /**
     * Displays the board to the console.
     */
    public void displayBoard() {
        System.out.println("Board: ");
        System.out.println("Rows | 1 | 2 | 3");
        System.out.println("-----+---+---+---");
        System.out.printf("1    | %c | %c | %c\n", board[0][0], board[0][1], board[0][2]);
        System.out.println("     +---+---+---");
        System.out.printf("2    | %c | %c | %c\n", board[1][0], board[1][1], board[1][2]);
        System.out.println("     +---+---+---");
        System.out.printf("3    | %c | %c | %c\n", board[2][0], board[2][1], board[2][2]);
    }

    public boolean isValidMove(int row, int column) {
        if (row < 1 || row > 3 || column < 1 || column > 3) {
            return false;
        }

        return board[row - 1][column - 1] == ' ';
    }

    public void claimSquare(int row, int column, char symbol) {
        board[row - 1][column - 1] = symbol;
    }

    /**
     * Allows for people to retrieve the board
     * 
     * @return board of the game
     */
    public char[][] getBoard() {
        return board;
    }

    public int getRows() {
        return board.length;
    }

    public int getColumns() {
        return board[0].length;
    }
}
