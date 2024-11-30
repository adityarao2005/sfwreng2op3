package com.mcmaster.se2op3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Manages the Tic-Tac-Toe grid, including placing markers and displaying
 * the board.
 */
public class Board {
    // The board is represented as a 2D array of characters
    private char[][] board;
    // The number of rows and columns in the board
    private int rows;
    private int columns;

    /**
     * Initializes the board with the specified number of rows and columns.
     * 
     * @param rows    the number of rows in the board
     * @param columns the number of columns in the board
     */
    public Board(int rows, int columns) {
        // Create a new 2D array to represent the board
        board = new char[rows][columns];
        this.rows = rows;
        this.columns = columns;

        // Initialize the board with empty spaces
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /**
     * Displays the board to the console.
     */
    public void displayBoard() {
        System.out.println("Board: ");

        StringBuilder row = new StringBuilder("Rows |");
        StringBuilder rowDivider = new StringBuilder("-----+");
        for (int i = 1; i <= columns; i++) {
            row.append(String.format(" %d |", i));
            rowDivider.append("---+");
        }

        System.out.println(row);
        System.out.println(rowDivider);

        for (int i = 0; i < rows; i++) {
            StringBuilder rowContent = new StringBuilder(String.format("%d    |", i + 1));
            for (int j = 0; j < columns; j++) {
                rowContent.append(String.format(" %c |", board[i][j]));
            }
            System.out.println(rowContent);
            System.out.println(rowDivider);
        }
    }

    /**
     * Checks if the board is full (i.e., no empty spaces).
     * 
     * @return true if the board is full, false otherwise
     */
    public boolean isValidMove(int row, int column) {
        // Check if the specified row and column are within the bounds of the board
        if (row < 1 || row > rows || column < 1 || column > columns) {
            return false;
        }

        // Check if the specified square is empty
        return board[row - 1][column - 1] == ' ';
    }

    /**
     * Gets all the valid moves on the board.
     * 
     * @return a list of valid moves as (row, column) pairs
     */
    public List<Map.Entry<Integer, Integer>> getValidMoves() {
        // Create a list to store the valid moves
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();

        // Iterate through the board and add the empty squares to the list
        for (int row = 0; row < getRows(); row++)
            for (int col = 0; col < getColumns(); col++)
                if (board[row][col] == ' ')
                    list.add(Map.entry(row + 1, col + 1));

        return list;
    }

    /**
     * Places a marker on the board at the specified row and column.
     * 
     * @param row    the row to place the marker
     * @param column the column to place the marker
     * @param symbol the symbol to place on the board
     */
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

    /**
     * Allows for people to retrieve the number of rows
     * 
     * @return number of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * Allows for people to retrieve the number of columns
     * 
     * @return number of columns
     */
    public int getColumns() {
        return columns;
    }
}
