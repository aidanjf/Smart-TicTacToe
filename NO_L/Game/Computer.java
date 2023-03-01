// A Computer class which is used to generate either the best move possible 
// or a completely random move. All moves returned are valid given a board state.
// Moves returned are represented as arrays of length 2, where the 0th element is 
// the row, and the 1st element is the column.

import java.util.*;

public class Computer {
    private Random random;
    private boolean isSmart;

    // Post: Constructs a new Computer object
    public Computer() {
        random = new Random();
    }

    public int[] generateMove(Board board) {
        if (isSmart) {
            return generateBestMove(board);
        } else {
            return generateDumbMove(board);
        }
    }

    public void setSmart(boolean isSmart) {
        this.isSmart = isSmart;
    }

    // Pre : Takes in a Board object
    // Post : returns the best possible move given the state of the board
    //        as an array of two elements. The first element is the row
    //        and the second element is the column
    // Adapted from : https://www.youtube.com/watch?v=trKjYdBASyQ&t=1033s
    private int[] generateBestMove(Board board) {
        int bestScore = -Integer.MIN_VALUE;
        int[] move = new int[2];
        for(int i = 0; i < board.SIZE; i++) {
            for(int j = 0; j < board.SIZE; j++) {
                if (board.isValidTile(i, j)) {
                    board.updateBoard(i, j , board.COMPUTER);
                    int score = minimax(board, false);
                    board.clearTile(i, j);
                    if (score > bestScore) {
                        bestScore = score;
                        move[0] = i;
                        move[1] = j;
                    }
                }
            }
        }
        return move;
    }

    // Private Helper method
    // Pre : Takes in a Board object and an isMaximizing boolean as parameters
    // Post : Returns an int representing the best possible outcome if isMaximizing
    //        is true or false given the state of the board
    private static int minimax(Board board, boolean isMaximizing) {
        int bestScore;
        if (board.isBoardFull() || board.findWinner() != board.EMPTY) {
            return minimaxValues(board.findWinner());
        } else if (isMaximizing) {
            bestScore = Integer.MIN_VALUE;
            for(int i = 0; i < board.SIZE; i++) {
                for(int j = 0; j < board.SIZE; j++) {
                    if (board.isValidTile(i, j)) {
                        board.updateBoard(i, j , board.COMPUTER);
                        int score = minimax(board, false);
                        board.clearTile(i, j);
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
        } else {
            bestScore = Integer.MAX_VALUE;
            for(int i = 0; i < board.SIZE; i++) {
                for(int j = 0; j < board.SIZE; j++) {
                    if (board.isValidTile(i, j)) {
                        board.updateBoard(i, j, board.USER);
                        int score = minimax(board, true);
                        board.clearTile(i, j);
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
        }
        return bestScore;
    }

    // Private helper method
    // Pre : takes in a char player as a parameter which represents the winner
    // Post : Returns the minimax value of the winning player
    private static int minimaxValues(char player) {
        if (player == Board.USER) {
            return -1;
        } else if (player == Board.COMPUTER) {
            return 1;
        } else {
            return 0;
        }
    }

    // Pre : Takes in a Board object as a parameter
    // Post : Returns a completely random, valid move given the state of the board
    //        the move is represented as an array of two elements. The first element is the row
    //        and the second element is the column
    private int[] generateDumbMove(Board board) {
        int[] tile = new int[2];
        tile[0] = random.nextInt(3);
        tile[1] = random.nextInt(3);
        while (!board.isValidTile(tile[0], tile[1])) {
            tile[0] = random.nextInt(3);
            tile[1] = random.nextInt(3);
        }
        return tile;
    }
}
