
import javax.swing.*;
import java.awt.*;

public class Board {

//    todo manage the board here
    public final String LEFT = "LEFT", RIGHT = "RIGHT", TOP = "TOP", BOTTOM = "BOTTOM";
    private int leftX, rightX, topX, bottomX, leftY, rightY, topY, bottomY;
    private JButton[][] gameBoard;

    private int square, stage, activeSquare;
//    square = the position on the board; when reaching 40 it means it finished the first stage
//    stage = there will be two stages: 1 - College, 2 - University. When the stage increases, the difficulty increases as well.

    public Board() {

        gameBoard = new JButton[10][10];

        leftX = 1;
        rightX = 1;
        topX = 0;
        bottomX = 9;

        leftY = 0;
        rightY = 9;
        topY = 0;
        bottomY = 0;

    }

    public int rollDice() {
        int number = (int) Math.floor(Math.random() * 6) + 1;

        //todo need to make the player move "number" tiles further
        return number;
    }

    public void doActiveTile(JButton activeTile) {

        activeTile.setText("Player");
//        activeTile.setIcon(new javax.swing.ImageIcon("images//character.png"));

    }

    public void addToList(JButton createdTile, String list) {

        //todo might need to add I and J in the method, or make a list instead of a matrix
        if (list.equals(LEFT)) {
            gameBoard[leftX][leftY] = createdTile;
            leftX++;
        } else if (list.equals(RIGHT)) {
            gameBoard[rightX][rightY] = createdTile;
            rightX++;
        } else if (list.equals(TOP)) {
            gameBoard[topX][topY] = createdTile;
            topY++;
        } else if (list.equals(BOTTOM)) {
            gameBoard[bottomX][bottomY] = createdTile;
            bottomY++;
        }

    }

    public void print() {

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.print(gameBoard[j][i].getText());
                } catch (java.lang.NullPointerException e) {
                    System.out.print("0");
                }
            }

            System.out.println();
        }

        gameBoard[0][7].setText("<html><b><u>T</u>wo</b><br>lines</html>");
        gameBoard[0][5].setText("<html><font color=#ffffdd>middle button</font></html>");

        gameBoard[0][2].setText("<html><div style='display:inline;"
                + "'>regular </div><div style='background-color:#336699;"
                + "color:#fff;display:inline;'>special</div>"
                + "<div style='display:inline;'> regular again");

        gameBoard[0][4].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/character-small.gif")));

    }

    public void Quiz() {

//        todo need to add questions and answers nested under buttons
       
        //todo need to create an array that holds the questions
        Object[] options = {"1", "Hero", "3", "4"};
        int[] answers = {0, 1, 2, 3};
        /* Make sure the answers and options are in the correct order - example Correct is second - answers = 1 */
        
        int n = JOptionPane.showOptionDialog(null, "What is 1 + 1 ?", "A Silly Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (n == answers[1]) {
            System.out.println("Correct");
        } else if (n == answers[0]) {
            System.out.println("Wrong");
        } else if (n == answers[2]) {
            System.out.println("Wrong");
        } else if (n == answers[3]) {
            System.out.println("Wrong");
        }
    }
}
