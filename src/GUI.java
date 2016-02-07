/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Harvey
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends Board implements ActionListener {

    // Initiates the JFrame Object. Gives it a title.
    JFrame frame = new JFrame("Start Screen");
    JFrame frame2 = new JFrame("Game Screen");
    JFrame frame3 = new JFrame("Conclusion Screen");

    //Buttons for frame
    JButton howToPlay, playButton, exitButton; // The buttons for "Throw", "Score" and "New Game"
    // buttons for frame 2
    JButton nextFrame, rollDice;
    // buttons for frame 3
    JButton goBackToMenu;


    // Text fields which are shown on the JFrame
    javax.swing.JLabel start;
    javax.swing.JLabel labelFrame2;
    javax.swing.JLabel labelFrame3;
    javax.swing.JLabel box1,box2,box3,box4,box5;




    JFrame message = new JFrame(); // for pop messages!

    public GUI() {
        //todo need to add a required textfield for the player name

//        frame.setLayout(new FlowLayout());

        // Sets the text and initiates the objects for the buttons
        playButton = new JButton("PLAY");
        exitButton = new JButton("QUIT");
        howToPlay = new JButton("HOW TO PLAY");
        nextFrame = new JButton("NEXT FRAME");
        rollDice = new JButton("ROLL THE DICE");
        goBackToMenu = new JButton("BACK TO MENU");


        // The main container for the JFrames
        //container for frame
        JPanel container = new JPanel();
        frame.setContentPane(container);
        //container for frame 2
        JPanel container2 = new JPanel();
        frame2.setContentPane(container2);
        //container for frame 3
        JPanel container3 = new JPanel();
        frame3.setContentPane(container3);

        // start panel with play button and exit button
        // for frame
        JPanel frame = new JPanel();
//        frame.setLayout(new BoxLayout(frame,BoxLayout.X_AXIS));
        frame.add(playButton);
        playButton.setPreferredSize(new Dimension(200, 100));
        frame.add(exitButton);
        exitButton.setPreferredSize(new Dimension(200, 100));
        frame.add(howToPlay);
        howToPlay.setPreferredSize(new Dimension(200, 100));


        start = new javax.swing.JLabel();
        //frame 1 animation of the dices
        start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.png")));
        box1 = new javax.swing.JLabel();
        //frame 1 animation of the dices
        box1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/box.png")));
        box2 = new javax.swing.JLabel();
        //frame 1 animation of the dices
        box2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/box.png")));
        box3 = new javax.swing.JLabel();
        //frame 1 animation of the dices
        box3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/character.gif")));
        box4 = new javax.swing.JLabel();
        //frame 1 animation of the dices
        box4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/box.png")));
        box5 = new javax.swing.JLabel();
        //frame 1 animation of the dices
        box5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/box.png")));

        //for frame 2
        JPanel frame2 = new JPanel();
        frame2.add(nextFrame);
//        labelFrame2 = new javax.swing.JLabel("Your in Frame 2");
//        frame2.add(labelFrame2);
        frame2.add(box1);
        frame2.add(box2);
        frame2.add(box3);
        frame2.add(box4);
        frame2.add(box5);

/* Start of creating the board */

        JButton ordinaryButton;
        int row = 10, column = 10;
        frame2.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);

        //todo need to make j=0 as now we have other buttons on the first line
        //todo need to remove magic numbers later and replace them with column and row
        for (int j = 1; j <= row; j++) {
            for (int i = 0; i < column; i++) {

                ordinaryButton = new JButton();

//                todo need to delete this after creating the list
//                int number = (j - 1) * 10 + i;
//                String text = Integer.toString(number);
//                ordinaryButton.setText(text);


                if (i == column - 1 && j == row) doActiveTile(ordinaryButton);

                //todo need to either create 4 lists to add the buttons in or one list with buttons in order
                //todo or we can do a matrix with 4 lines and 10 columns.
                if (j == 1) {//top line
                    gbc.ipady = 30;
                    gbc.gridx = i;
                    gbc.gridy = j;
                    gbc.gridwidth = 1;
                    addToList(ordinaryButton,TOP);
                    ordinaryButton.setText("t");
                    frame2.add(ordinaryButton, gbc); //add in the frame
                } else {
                    if (j == 10) {//bottom line
                        gbc.ipady = 30;
                        gbc.gridx = i;
                        gbc.gridy = j;
                        gbc.gridwidth = 1;
                        addToList(ordinaryButton,BOTTOM);
                        ordinaryButton.setText("b");
                        frame2.add(ordinaryButton, gbc); //add in the frame
                    } else {
                        if (i == 0) { // left-hand side column
                            gbc.ipady = 30;
                            gbc.gridx = i;
                            gbc.gridy = j;
                            gbc.gridwidth = 1;
                            addToList(ordinaryButton,LEFT);
                            ordinaryButton.setText("l");
                            frame2.add(ordinaryButton, gbc); //add in the frame
                        } else {
                            if (i == 9) { // right-hand side column
                                gbc.ipady = 30;
                                gbc.gridx = i;
                                gbc.gridy = j;
                                gbc.gridwidth = 1;
                                addToList(ordinaryButton,RIGHT);
                                ordinaryButton.setText("r");
                                frame2.add(ordinaryButton, gbc); //add in the frame
                            }
                        }
                    }
                }


            }

        }

/* End of creating the board */

        /* adding constraints for roll dice and next frame */
        gbc.ipady = 30;
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        frame2.add(rollDice, gbc); //add in the frame

//todo need to remove magic numbers later and replace them with column and row

        gbc.ipady = 30;
        gbc.gridx = 6;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        frame2.add(nextFrame, gbc); //add in the frame
        /* END OF adding constraints for roll dice and next frame */

        //for frame 3
        JPanel frame3 = new JPanel();
        frame3.add(goBackToMenu);
        labelFrame3 = new javax.swing.JLabel("Your in Frame 3");
        frame3.add(labelFrame3);

        // Adds the fields to the panel
        // Adds all the panels to the container
        container.add(start);
        container.add(frame);
        container2.add(frame2);
        container3.add(frame3);

        // Action Listeners for the buttons
        howToPlay.addActionListener(this);
        playButton.addActionListener(this);
        exitButton.addActionListener(this);
        nextFrame.addActionListener(this);
        rollDice.addActionListener(this);
        goBackToMenu.addActionListener(this);


        // Starts up the UI
        startGui();
        print();
    }

    // Initiates the window to display it

    public void startGui() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets default close operation (when user clicks X)
        frame.setSize(1000, 750); // Sets a default window size.
        frame.setVisible(true); // Sets the window to be visible.

        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets default close operation (when user clicks X)
        frame2.setSize(1000, 750); // Sets a default window size.
        frame2.setVisible(false);

        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets default close operation (when user clicks X)
        frame3.setSize(1000, 750); // Sets a default window size.
        frame3.setVisible(false);
    }

    // Code behind the buttons. This is called when the 4 buttons are clicked
    @Override
    public void actionPerformed(ActionEvent e) {

        //play button
        if (e.getActionCommand() == "PLAY") {

            Game newGame = new Game();

            frame2.setVisible(true);
            frame.setVisible(false);
        } else if (e.getActionCommand() == "HOW TO PLAY") {
            //frame2.setVisible(false);
            JOptionPane.showMessageDialog(null, "Include how to play intructions here");
        } else if (e.getActionCommand() == "QUIT") {
            int input = JOptionPane.showOptionDialog(null, "Press CANCEL or OK to exit!", "Are you sure?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if (input == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        } else if (e.getActionCommand() == "NEXT FRAME") {
            frame.setVisible(false);
            frame2.setVisible(false);
            frame3.setVisible(true);
        } else if (e.getActionCommand() == "BACK TO MENU") {
            frame.setVisible(true);
            frame2.setVisible(false);
            frame3.setVisible(false);
        } else if (e.getActionCommand() == "ROLL THE DICE") {

            int randomNumber = 0;
            randomNumber = rollDice();
            JOptionPane.showMessageDialog(null, randomNumber);

        }

    }

}