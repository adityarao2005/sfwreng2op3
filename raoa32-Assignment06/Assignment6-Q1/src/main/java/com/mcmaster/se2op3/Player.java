package com.mcmaster.se2op3;

/**
 * Represents a player in the game, including their symbol ('X' or 'O')
 */
public abstract class Player {
    public static final char MARKER_X = 'X';
    public static final char MARKER_O = 'O';

    private char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public abstract void makeTurn(Board board);

}
