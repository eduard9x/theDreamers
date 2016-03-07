
import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class Board {

    //    todo manage the board here
    public final String LEFT = "LEFT", RIGHT = "RIGHT", TOP = "TOP", BOTTOM = "BOTTOM";
    //    square = the position on the board; when reaching 40 it means it finished the first stage
//    stage = there will be two stages: 1 - College, 2 - University. When the stage increases, the difficulty increases as well.
    private int leftX, rightX, topX, bottomX, leftY, rightY, topY, bottomY, playerX, playerY;
    private JButton[][] gameBoard;
    private int square, stage, activeSquare;
    private String[] data;
    private int playerPosition;

    public Board() {

        playerPosition = 0;

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

        if(playerX==9 && playerY==9) gameBoard[playerX][playerY].setText("Start");

        gameBoard[playerX][playerY].setIcon(null);
        playerPosition += dice;

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

        } /* End of Bottom left corner constraints */ else {// Not on the bottom line

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
            } /* End of Top left corner constraints */ else {

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
                } /* End of Top right corner constraints */ else {

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
    }

    public void Quiz() {

        String question = "What is the correct answer?";
        String subject = "Mathematics";
        
        String correctAnswer = "correct";
        String wrongAnswer1 = "wrong1";
        String wrongAnswer2 = "wrong2";
        String wrongAnswer3 = "wrong3";

        double randomStuff = Math.floor(Math.random()*4);
        int randomNumber1 = (int) randomStuff;

        int positionCorrectAnswer = randomNumber1;
        int randomNumber2;

        do {
            randomStuff = Math.floor(Math.random() * 4);
            randomNumber2 = (int) randomStuff;
        }while(randomNumber1 == randomNumber2);

        int positionWrongAnswer1 = randomNumber2;
        int randomNumber3;

        do {
            randomStuff = Math.floor(Math.random() * 4);
            randomNumber3 = (int) randomStuff;
        }while(randomNumber1 == randomNumber3 || randomNumber2 == randomNumber3);

        int positionWrongAnswer2 = randomNumber3;
        int randomNumber4;

        do {
            randomStuff = Math.floor(Math.random() * 4);
            randomNumber4 = (int) randomStuff;
        }while(randomNumber1 == randomNumber4 || randomNumber2 == randomNumber4 || randomNumber3 == randomNumber4);

        int positionWrongAnswer3 = randomNumber4;

        String[] options = new String[4];

        for (int i = 0; i < 4; i++) {
            if (i == positionCorrectAnswer) {
                options[i] = correctAnswer;
            } else if (i == positionWrongAnswer1) {
                options[i] = wrongAnswer1;
            } else if (i == positionWrongAnswer2) {
                options[i] = wrongAnswer2;
            } else if (i == positionWrongAnswer3) {
                options[i] = wrongAnswer3;
            }
        }
              
        int n = JOptionPane.showOptionDialog(null, question, subject, 0, 1, null, options, stage);

        System.out.println("questions number:" + playerPosition);

        if (n == positionCorrectAnswer) {
            System.out.println(correctAnswer);
        }  else {
            System.out.println(" wrong answer ");
        }

    }

    public void readData() {
        try {
            Scanner input = new Scanner(new File("data.txt"));
            String buildMe = input.nextLine();
            data = buildMe.split(",");
            input.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

}
