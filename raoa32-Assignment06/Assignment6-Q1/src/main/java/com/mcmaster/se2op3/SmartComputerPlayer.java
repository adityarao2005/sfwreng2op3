package com.mcmaster.se2op3;

public class SmartComputerPlayer extends ComputerPlayer {
    public SmartComputerPlayer(char symbol) {
        super(symbol);
    }

    /**
     * 1. Prioritize Winning: If you have two in a row (either horizontally,
     * vertically, or diagonally),
     * place your third mark to complete the row and win the game.
     * 2. Block Your Opponent: If your opponent has two in a row, place your mark in
     * the third
     * spot to block them from winning.
     * 3. Play in the Center: If the center square is available, take it.
     * Controlling the center gives
     * you more opportunities to create winning combinations.
     * 4. Take Corners: If the center is taken, opt for a corner. Corners are more
     * valuable than
     * edge squares because they can be part of multiple winning lines (horizontal,
     * vertical,
     * and diagonal)
     */
    @Override
    public void makeTurn(Board board) {

        // If the computer can win, do so
        if (tryWinning(board)) {
            return;
        }

        // If the computer can block the opponent, do so
        if (tryBlocking(board)) {
            return;
        }

        // If the computer can take the center, do so
        if (tryCenter(board)) {
            return;
        }

        // If the computer can take a corner, do so
        if (tryCorners(board)) {
            return;
        }

        // Otherwise do this
        super.makeTurn(board);
    }

    private boolean tryWinningOrBlocking(Board board, char symbol) {
        int rowToClaim = 0;
        int columnToClaim = 0;
        int countOfSymbol = 0;
        int countOfWhitespace = 0;

        // Check rows
        for (int i = 0; i < board.getRows(); i++) {
            // Define the count of the symbol and whitespace
            rowToClaim = columnToClaim = 0;
            countOfSymbol = countOfWhitespace = 0;

            for (int j = 0; j < board.getColumns(); j++) {
                // Check if the symbol is the same
                if (board.getBoard()[i][j] == symbol) {
                    countOfSymbol++;
                    // Check if the square is empty
                } else if (board.getBoard()[i][j] == ' ') {
                    rowToClaim = i;
                    columnToClaim = j;
                    countOfWhitespace++;
                }
            }

            // If there is only one empty square and the rest are the same symbol
            if (countOfSymbol == board.getColumns() - 1 && countOfWhitespace == 1) {
                // Claim the square
                board.claimSquare(rowToClaim + 1, columnToClaim + 1, getSymbol());
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < board.getColumns(); i++) {
            // Define the count of the symbol and whitespace
            rowToClaim = columnToClaim = 0;
            countOfSymbol = countOfWhitespace = 0;

            for (int j = 0; j < board.getRows(); j++) {
                // Check if the symbol is the same
                if (board.getBoard()[j][i] == symbol) {
                    countOfSymbol++;
                    // Check if the square is empty
                } else if (board.getBoard()[j][i] == ' ') {
                    rowToClaim = j;
                    columnToClaim = i;
                    countOfWhitespace++;
                }
            }

            // If there is only one empty square and the rest are the same symbol
            if (countOfSymbol == board.getRows() - 1 && countOfWhitespace == 1) {
                // Claim the square
                board.claimSquare(rowToClaim + 1, columnToClaim + 1, getSymbol());
                return true;
            }
        }

        // Check left diagonal

        // Define the count of the symbol and whitespace
        countOfSymbol = countOfWhitespace = 0;
        rowToClaim = columnToClaim = 0;

        // Check the left diagonal
        for (int i = 0; i < board.getRows(); i++) {
            // Check if the symbol is the same
            if (board.getBoard()[i][i] == symbol) {
                countOfSymbol++;
                // Check if the square is empty
            } else if (board.getBoard()[i][i] == ' ') {
                rowToClaim = i;
                columnToClaim = i;
                countOfWhitespace++;
            }
        }

        // If there is only one empty square and the rest are the same symbol
        if (countOfSymbol == board.getRows() - 1 && countOfWhitespace == 1) {
            // Claim the square
            board.claimSquare(rowToClaim + 1, columnToClaim + 1, getSymbol());
            return true;
        }
        // Check right diagonal
        countOfSymbol = 0;
        countOfWhitespace = 0;
        rowToClaim = columnToClaim = 0;

        // Check the right diagonal
        for (int i = 0; i < board.getRows(); i++) {
            // Check if the symbol is the same
            if (board.getBoard()[i][board.getRows() - i - 1] == symbol) {
                countOfSymbol++;
                // Check if the square is empty
            } else if (board.getBoard()[i][board.getRows() - i - 1] == ' ') {
                rowToClaim = i;
                columnToClaim = board.getRows() - i - 1;
                countOfWhitespace++;
            }
        }

        if (countOfSymbol == board.getRows() - 1 && countOfWhitespace == 1) {
            // Claim the square
            board.claimSquare(rowToClaim + 1, columnToClaim + 1, getSymbol());
            return true;
        }

        return false;
    }

    private boolean tryWinning(Board board) {
        return tryWinningOrBlocking(board, getSymbol());
    }

    private boolean tryBlocking(Board board) {
        return tryWinningOrBlocking(board, getSymbol() == MARKER_O ? MARKER_X : MARKER_O);
    }

    private boolean tryCenter(Board board) {
        // If the center square is available, take it
        if (board.isValidMove(board.getRows() / 2, board.getColumns() / 2)) {
            // Claim the square
            board.claimSquare(board.getRows() / 2, board.getColumns() / 2, getSymbol());
            return true;
        }
        return false;
    }

    private boolean tryCorners(Board board) {
        // Get the valid moves
        var validMoves = board.getValidMoves().stream()
                // Filter for the corners which means x or y is 0 or the max
                .filter((entry) -> {
                    return
                    // Check if x or y is 0
                    entry.getKey() == 1 || entry.getValue() == 1 ||
                    // Check if x or y is the max
                            entry.getKey() == board.getRows() || entry.getValue() == board.getColumns();
                });

        if (validMoves.count() > 0) {
            // Get the first corner
            var corner = validMoves.findFirst().get();
            // Claim the square
            board.claimSquare(corner.getKey(), corner.getValue(), getSymbol());
            return true;
        }
        return false;
    }
}
