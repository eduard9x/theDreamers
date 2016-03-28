
import javafx.beans.property.adapter.JavaBeanObjectProperty;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class Board {

    public final String LEFT = "LEFT", RIGHT = "RIGHT", TOP = "TOP", BOTTOM = "BOTTOM";
    //    square = the position on the board; when reaching 40 it means it finished the first stage
    //    stage = there will be two stages: 1 - College, 2 - University. When the stage increases, the difficulty increases as well.
    private int leftX, rightX, topX, bottomX, leftY, rightY, topY, bottomY, playerX, playerY;
    private JButton[][] gameBoard;
    private int square, stage, activeSquare;
    private String[] data;
    private int playerPosition;
    private int mathematics, science, computerScience, geography, history;

    public Board() {

        readData();
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

        mathematics = 0;
        science = 0;
        computerScience = 0;
        geography = 0;
        history = 0;
    }

    public int rollDice() {
        int number = (int) Math.floor(Math.random() * 6) + 1;

        return number;
    }

    public void doActiveTile(JButton activeTile) {
        activeTile.setIcon(new javax.swing.ImageIcon("images/character.gif"));
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

        if (playerX == 9 && playerY == 9) gameBoard[playerX][playerY].setText("Start");

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

        String question = data[playerPosition * 6 + 0];
        String correctAnswer = data[playerPosition * 6 + 1];
        String wrongAnswer1 = data[playerPosition * 6 + 2];
        String wrongAnswer2 = data[playerPosition * 6 + 3];
        String wrongAnswer3 = data[playerPosition * 6 + 4];
        String subject = data[playerPosition * 6 + 5];

        double randomStuff = Math.floor(Math.random() * 4);
        int randomNumber1 = (int) randomStuff;

        int positionCorrectAnswer = randomNumber1;
        int randomNumber2;

        do {
            randomStuff = Math.floor(Math.random() * 4);
            randomNumber2 = (int) randomStuff;
        } while (randomNumber1 == randomNumber2);

        int positionWrongAnswer1 = randomNumber2;
        int randomNumber3;

        do {
            randomStuff = Math.floor(Math.random() * 4);
            randomNumber3 = (int) randomStuff;
        } while (randomNumber1 == randomNumber3 || randomNumber2 == randomNumber3);

        int positionWrongAnswer2 = randomNumber3;
        int randomNumber4;

        do {
            randomStuff = Math.floor(Math.random() * 4);
            randomNumber4 = (int) randomStuff;
        } while (randomNumber1 == randomNumber4 || randomNumber2 == randomNumber4 || randomNumber3 == randomNumber4);


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

        for (int i = 0; i < 4; i++)
            options[i] = "<html><body width='100' height='50'><h3>" + options[i] + "</h3></body></html>";

        String questionHolder = "<html><body width='450'><h2>" + question + "</h2></body></html>";


        Icon questionIcon = new javax.swing.ImageIcon(getClass().getClassLoader().getResource("images/questionLogo.png"));


        int n = JOptionPane.showOptionDialog(null, questionHolder, subject, 0, 1, questionIcon, options, stage);


//        System.out.println("questions number:" + playerPosition);

        if (n == positionCorrectAnswer) {
            if (subject.equals("Maths")) {
                if (mathematics < 6)
                    mathematics++;
            } else if (subject.equals("Computer Science")) {
                if (computerScience < 6)
                    computerScience++;
            } else if (subject.equals("Science")) {
                if (science < 6)
                    science++;
            } else if (subject.equals("History")) {
                if (history < 6)
                    history++;
            } else if (subject.equals("Geography")) {
                if (geography < 6)
                    geography++;
            }

            System.out.println(" correct ");
        } else {
            System.out.println(" wrong answer ");
        }
    }

    public void readData() {
        System.out.println("READING DATA FROM FILE!!");

        try {
            Scanner input = new Scanner(new File("databaseLocalFile.txt"));
            String buildMe = input.nextLine();
            data = buildMe.split(";;;");
            input.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }

        //todo need to remove this later. It is here just for testing purposes
//        for(int i=0;i<data.length;i++)
//            System.out.println(data[playerPosition]);
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public String getMathematics() {
        return "Mathematics: " + Integer.toString(mathematics) + "        ";
    }

    public String getScience() {
        return "Science: " + Integer.toString(science) + "        ";
    }

    public String getComputerScience() {
        return "Computer Science:" + Integer.toString(computerScience) + "        ";
    }

    public String getGeography() {
        return "Geography: " + Integer.toString(geography) + "        ";
    }

    public String getHistory() {
        return "History: " + Integer.toString(history) + "        ";
    }


    public int getMathematicsValue() {
        return mathematics;
    }

    public int getHistoryValue() {
        return history;
    }

    public int getGeographyValue() {
        return geography;
    }

    public int getScienceValue() {
        return science;
    }

    public int getComputerScienceValue() {
        return computerScience;
    }


}