//This was our attempt at implementing a GUI with Swing. 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NO_L2 {

    private static JButton[][] boardUI;
    private static JFrame window;
    private static Board board;
    private static Computer ai;

    public static void main(String[] args) {
        board = new Board();
        ai = new Computer();
        ai.setSmart(true);
        boardUI = new JButton[board.SIZE][board.SIZE];


        window = new JFrame("Tic-Tac-Toe");
        window.setSize(500, 500);
        window.setLayout(new GridLayout(board.SIZE, board.SIZE));
        
        for (int i = 0; i < board.SIZE; i++) {
            for (int j = 0; j < board.SIZE; j++) {
                boardUI[i][j] = new JButton();
                window.add(boardUI[i][j]);
                boardUI[i][j].addActionListener(new ButtonListener());
                boardUI[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
            }
        }

        window.setVisible(true);
    }

    private static class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            int row = -1;
            int col = -1;
            for (int i = 0; i < Board.SIZE; i++) {
                for (int j = 0; j < Board.SIZE; j++) {
                    if (boardUI[i][j] == button) {
                        row = i;
                        col = j;
                    }
                }
            }
            if (board.isValidTile(row, col)) {
                board.updateBoard(row, col, Board.USER);
                button.setText("" + Board.USER);

                int[] tile = ai.generateMove(board);
                int aiRow = tile[0];
                int aiCol = tile[1];
                board.updateBoard(aiRow, aiCol, Board.COMPUTER);
                boardUI[aiRow][aiCol].setText("" + Board.COMPUTER);
            }

            if (board.isBoardFull() || board.findWinner() != Board.EMPTY) {
                System.out.println("done");
                JWindow w = new JWindow();
                JLabel l = new JLabel("The game is over!");
                JButton b = new JButton("Quit");
                b.addActionListener(new EndListener());
                JPanel p = new JPanel();
                p.add(l);
                p.add(b);

                w.add(p);
                w.setSize(200, 50);
                w.setLocation(150, 200);

                w.setVisible(true);
            }
        }
    }

    private static class EndListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            window.dispose();
            System.exit(0);
        }
    }

}
