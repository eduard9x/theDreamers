
import javax.swing.*;

public class Board {

    //    todo manage the board here
    public final String LEFT = "LEFT", RIGHT = "RIGHT", TOP = "TOP", BOTTOM = "BOTTOM";
    //    square = the position on the board; when reaching 40 it means it finished the first stage
//    stage = there will be two stages: 1 - College, 2 - University. When the stage increases, the difficulty increases as well.
    private int leftX, rightX, topX, bottomX, leftY, rightY, topY, bottomY, playerX, playerY;
    private JButton[][] gameBoard;
    private int square, stage, activeSquare;

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

        playerX = 9;
        playerY = 9;


    }

    public int rollDice() {
        int number = (int) Math.floor(Math.random() * 6) + 1;

        //todo need to make the player move "number" tiles further
        return number;
    }

    public void doActiveTile(JButton activeTile) {

        activeTile.setIcon(new javax.swing.ImageIcon("images//character.png"));

    }

    public void addToList(JButton createdTile, String list) {

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

    public void doMove(int dice) {

//        gameBoard[playerX][playerY].setText("");
        gameBoard[playerX][playerY].setIcon(null);


        /* Start of Bottom left corner constraints */
        if (playerX == bottomX) {

            if (playerY - dice < leftY) //out of border
            {
                int difference = playerY - dice;
                //find how many rows to go up

                playerX = playerX + difference; //go up the difference
                playerY = leftY;
            } else {
                playerY = playerY - dice;
            }

        }
        /* End of Bottom left corner constraints */

        else {// Not on the bottom line

            /* Start of Top left corner constraints */
            if (playerY == leftY) {
                if (playerX - dice < leftY) //out of border
                {
                    int difference = playerX - dice;
                    //find how many rows to go up

                    playerY = playerY - difference; //go right the difference
                    playerX = topX;
                } else {
                    playerX = playerX - dice;
                }
            }
            /* End of Top left corner constraints */

            else {

                 /* Start of Top right corner constraints */
                if (playerX == topX) {
                    if (playerY + dice > rightY) //out of border
                    {
                        int difference = playerY + dice - rightY;
                        //find how many rows to go up

                        playerX = playerX + difference; //go down the difference
                        playerY = rightY;
                    } else {
                        playerY = playerY + dice;
                    }
                }
                 /* End of Top right corner constraints */
                else {

                     /* Start of Bottom right corner constraints */
                    if (playerY == rightY) {
                        if (playerX + dice > rightY) //out of border
                        {
                            int difference = playerX + dice - rightY;
                            //find how many rows to go up

                            playerY = playerY - difference; //go left the difference
                            playerX = rightY;
                        } else {
                            playerX = playerX + dice;
                        }
                    }
                 /* End of Bottom right corner constraints */

                }

            }


        }


        gameBoard[playerX][playerY].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/character.gif")));


    }


    public void print() {

        gameBoard[playerX][playerY].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/character.gif")));

        /*

        *** How to style buttons ***

        gameBoard[0][7].setText("<html><b><u>T</u>wo</b><br>lines</html>");
        gameBoard[0][5].setText("<html><font color=#ffffdd>middle button</font></html>");

        gameBoard[0][2].setText("<html><div style='display:inline;"
                + "'>regular </div><div style='background-color:#336699;"
                + "color:#fff;display:inline;'>special</div>"
                + "<div style='display:inline;'> regular again");

        gameBoard[0][4].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/character-small.gif")));
        */
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
