// Aidan Jay, Aniruddh Bharath, Wonyoung Kim
// CSE 143
// Final Project: NO_L
// This NO_L class runs and plays the actual game of TicTacToe. The user will interact with prompts
// to play this unbeatable TicTacToe bot.

import java.util.*;

public class NO_L {
    // Takes in user input
    private static Scanner input;

    // Main method which actually runs the whole program
    public static void main(String[] args) {
        Board board = new Board();
        Computer ai = new Computer();
        input = new Scanner(System.in);

        String response = promptToPlayGame().toLowerCase();
        while (response.contains("y")) {
            System.out.println();
            System.out.print("Would you like to play a  smart computer (yes or no)? ");
            ai.setSmart(isSmart(input.next().toLowerCase()));
            System.out.println("You are playing as X . . .good luck\n");
            playOneGame(board, ai);
            response = promptToPlayGame();
        }       
    }

    private static boolean isSmart(String response) {
        if (response.contains("y")) {
            return true;
        } else {
            return false;
        }
    }

    // Private helper method
    // Post: Returns a String representing whether or not the user wants to playOneGame
    //       String that contains "y" indicates yes, otherwise no
    private static String promptToPlayGame() {
        //TODO
        System.out.print("Fancy a game of Tic Tac Toe (yes or no)? ");
        String response = input.next();
        response = response.toLowerCase();
        return response;
    }

    // Private helper method
    // Pre: Takes in a Board and Computer object
    // Post: Plays one whole game of TicTacToe and prints the winner
    private static void playOneGame(Board board, Computer ai) {
        char winner = board.EMPTY;
        board.displayBoard();
        while (!board.isBoardFull()) {
            // Do user move
            int[] userTile = getUserTile(board);
            board.updateBoard(userTile[0], userTile[1], board.USER);
            board.displayBoard();
            winner = board.findWinner();
            if (winner != board.EMPTY || board.isBoardFull()) {
                break;
            }

            // Do computer move
            System.out.println();
            System.out.println("Now it's the computer's turn:");
            //int[] aiTile = ai.generateDumbMove(board);
            int[] aiTile = ai.generateMove(board);
            board.updateBoard(aiTile[0], aiTile[1], board.COMPUTER);
            board.displayBoard();
            winner = board.findWinner();
            if (winner != board.EMPTY) {
                break;
            }
        }

        printGameResult(winner);
        board.clearBoard();  
    }

    // Private helper method
    // Pre: Takes in a Board object as a parameter
    //      If input is not integer, throws InputMismatchException
    //      Reprompts user if input integer is not a valid input
    // Post : Returns an array of length two where the first element is the 
    //        user's desired row and the second element is the desired column
    private static int[] getUserTile(Board board) {
        // tile[0] is the row, tile[1] is the column
        int[] tile = new int[2];
        System.out.print("What row would you like? (1-3)? ");
        int row = input.nextInt();

        System.out.print("What column would you like? (1-3)? ");
        int col = input.nextInt();
        while (!board.isValidTile(row - 1, col - 1)) {
            System.out.println("That is not a valid tile, please re-enter:");
            System.out.print("What row would you like? (1-3)? ");
            row = input.nextInt();
            System.out.print("What column would you like? (1-3)? ");
            col = input.nextInt();
        }
        tile[0] = row - 1;
        tile[1] = col - 1;
        return tile;
    }

    // Private helper method
    // Pre: Takes in the winner char as a parameter
    // Post: Prints the winner of the game
    private static void printGameResult(char winner) {
        System.out.println();
        // Board.EMPTY(' ') represents a draw
        if (winner == Board.EMPTY) {
            System.out.println("It's a draw!");
        } else if (winner == Board.COMPUTER) {
            System.out.println("The computer beat you!");
        } else {
            System.out.println("You won!");
        }
    }
}
