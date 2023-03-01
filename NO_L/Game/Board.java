// A Board class which is used to keeps track of the state of a tic-tac-toe isGameOver
// Size of the board is 3 by 3. The user's marks are represented with a 'X' and the computer's
// markings are represented with an 'O'.

import java.util.Arrays;

public class Board {
    
    private char[][] board;
    private boolean isGameOver;
    public static final char EMPTY = ' ';
	public static final char COMPUTER = 'O';
    public static final char USER = 'X';
    public static final int SIZE = 3;

    // Post: Constructs a new Board object
    public Board() {
        board = new char[SIZE][SIZE];
        clearBoard();
    }

    // Post: Prints out the current board state
    public void displayBoard() {
        System.out.println(" " + board[0][0] + " : " + board[0][1] + " : " + board[0][2]);
        for (int row = 1; row < SIZE; row++) {
            System.out.println("-----------");
            System.out.println(" " + board[row][0] + " : " + board[row][1] + " : " + board[row][2]);
        }
    }

    // Post : Checks through the board for a winner
    //        When three marks are aligned either vertical, horizontal, or diagonally
    //        it is a win
    //        Returns the winner if there is a winner and returns empty if no winner
    public char findWinner() {
        // Checks rows
        for (int row = 0; row < SIZE; row++) {
            char start = board[row][0];
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY || board[row][col] != start) {
                    break;
                } else if (col == SIZE - 1) {
                    return board[row][col];
                }
            }
        }

        // Checks columns
        for (int col = 0; col < SIZE; col++) {
            char start = board[0][col];
            for (int row = 0; row < SIZE; row++) {
                if (board[row][col] == EMPTY || board[row][col] != start) {
                    break;
                } else if (row == SIZE - 1) {
                    return board[row][col];
                }
            }
        }

        // Checks downward diagonal
        for (int row = 0; row < SIZE; row++) {
            
            if (board[row][row] == EMPTY || board[row][row] != board[0][0]) {
                break;
            } else if (row == SIZE - 1) {
                return board[row][row];
            }
        }

        // Checks upward diagonal
        for (int row = 0; row < SIZE; row++) {
            if (board[row][SIZE - row - 1] == EMPTY || board[row][SIZE - row - 1] != board[0][2]) {
                break;
            } else if (row == SIZE - 1) {
                return board[row][SIZE - row - 1];
            }
        }


        //  -If no winner return empty(' ')
        return EMPTY;
    }

    // Pre: Takes in given row, column, and player
    // Post: Given the row and column by the user, updates the current board
    public void updateBoard(int row, int col, char player) {
        board[row][col] = player;
    }

    // Post: Returns whether the given row and column is a valid clearTile
    //       Tile is valid if tile is within range of board and empty
    public boolean isValidTile(int row, int col) {
        return (row >= 0 && row < SIZE) && (col >= 0 && col < SIZE) && board[row][col] == EMPTY;
    }

    // Post: Returns whether the board is full
    public boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    // Pre: takes in given row and column
    // Post: Clears the tile at the given row and column
    public void clearTile(int row, int col) {
        board[row][col] = EMPTY;
    }

    // Post: Clears the whole board
    public void clearBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }
}
