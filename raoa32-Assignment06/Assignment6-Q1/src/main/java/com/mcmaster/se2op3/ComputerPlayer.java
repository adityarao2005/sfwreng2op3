package com.mcmaster.se2op3;

import java.util.Collections;

// Represents a computer player in the Tic-Tac-Toe game
public class ComputerPlayer extends Player {

    /**
     * Initializes a new computer player with the specified symbol.
     * 
     * @param symbol the symbol of the player
     */
    public ComputerPlayer(char symbol) {
        super(symbol);
    }

    /**
     * Makes a turn for the computer player.
     * 
     * @param board the game board
     */
    @Override
    public void makeTurn(Board board) {
        // Gets the valid moves and gets a random one from there
        var availableSpots = board.getValidMoves();
        Collections.shuffle(availableSpots);
        var spot = availableSpots.get(0);

        // Claim the square
        board.claimSquare(spot.getKey(), spot.getValue(), getSymbol());
    }
}
