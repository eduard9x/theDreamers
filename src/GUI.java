import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Formatter;


public class GUI extends Board implements ActionListener {

    // Initiates the JFrame Object. Gives it a title.
    JFrame spalshScreen = new JFrame("Loading Screen");
    JFrame frame = new JFrame("Start Screen");
    JFrame frame2 = new JFrame("Game Screen");
    JFrame frame3 = new JFrame("Conclusion Screen");

    //Buttons for frame
    JButton howToPlay, playButton, exitButton; // The buttons for "Throw", "Score" and "New Game"
    // buttons for frame 2
    JButton nextFrame, rollDice;
    // buttons for frame 3
    JButton saveCareerProspects, exitApplication;


    // Text fields which are shown on the JFrame
    javax.swing.JLabel loading;
    javax.swing.JLabel start;
    javax.swing.JLabel skillsLabel, mathematicsLabel, scienceLabel, computerScienceLabel, historyLabel, geographyLabel;
    javax.swing.JTextField playerName;
    javax.swing.JLabel careersLabel, secondColMaths, secondColScience, secondColCompScience, secondColHistory, secondColGeography;

    JFrame message = new JFrame(); // for pop messages!

    public GUI() {

        // Sets the text and initiates the objects for the buttons
        playButton = new JButton("PLAY");
        exitButton = new JButton("QUIT");
        howToPlay = new JButton("HOW TO PLAY");
        nextFrame = new JButton("NEXT FRAME");
        rollDice = new JButton("ROLL THE DICE");
        saveCareerProspects = new JButton("Save career prospects");
        exitApplication = new JButton("Exit application");


        // The main container for the JFrames
        //container for frame

        JPanel welcome = new JPanel();
        spalshScreen.setContentPane(welcome);
        JPanel container = new JPanel();
        frame.setContentPane(container);
        //container for frame 2
        JPanel container2 = new JPanel();
        frame2.setContentPane(container2);
        //container for frame 3
        JPanel container3 = new JPanel();
        frame3.setContentPane(container3);


        loading = new javax.swing.JLabel();
        loading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hexLoader.gif")));

        // start panel with play button and exit button
        // for frame

        playerName = new javax.swing.JTextField();
        playerName.setText("Player");
        playerName.setLocation(100, 100);
        playerName.setPreferredSize(new Dimension(100, 50));

        JPanel frame = new JPanel();

        frame.add(playerName);

        frame.add(playButton);
        playButton.setPreferredSize(new Dimension(200, 100));
        frame.add(exitButton);
        exitButton.setPreferredSize(new Dimension(200, 100));
        frame.add(howToPlay);
        howToPlay.setPreferredSize(new Dimension(200, 100));

        //board image start screen
        start = new javax.swing.JLabel();
        start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.png")));

        //for frame 2
        JPanel frame2 = new JPanel();
        frame2.add(nextFrame);


/* Start of creating the board */

        JButton ordinaryButton;
        int row = 10, column = 10;
        frame2.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);

        for (int j = 1; j <= row; j++) {
            for (int i = 0; i < column; i++) {

                ordinaryButton = new JButton();

                if (i == column - 1 && j == row) doActiveTile(ordinaryButton);

                if (j == 1) {//top line
                    gbc.ipady = 30;
                    gbc.gridx = i;
                    gbc.gridy = j;
                    gbc.gridwidth = 1;
                    addToList(ordinaryButton, TOP);
                    frame2.add(ordinaryButton, gbc); //add in the frame
                } else {
                    if (j == 10) {//bottom line
                        gbc.ipady = 30;
                        gbc.gridx = i;
                        gbc.gridy = j;
                        gbc.gridwidth = 1;
                        addToList(ordinaryButton, BOTTOM);
                        frame2.add(ordinaryButton, gbc); //add in the frame
                    } else {
                        if (i == 0) { // left-hand side column
                            gbc.ipady = 30;
                            gbc.gridx = i;
                            gbc.gridy = j;
                            gbc.gridwidth = 1;
                            addToList(ordinaryButton, LEFT);
                            frame2.add(ordinaryButton, gbc); //add in the frame
                        } else {
                            if (i == 9) { // right-hand side column
                                gbc.ipady = 30;
                                gbc.gridx = i;
                                gbc.gridy = j;
                                gbc.gridwidth = 1;
                                addToList(ordinaryButton, RIGHT);
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


        gbc.ipady = 30;
        gbc.gridx = 6;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        frame2.add(nextFrame, gbc); //add in the frame
        /* END OF adding constraints for roll dice and next frame */


        //for frame 3
        JPanel frame3 = new JPanel();

        frame3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.ipady = 30;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        frame3.add(saveCareerProspects, gbc);

        skillsLabel = new javax.swing.JLabel("SKILLS");
        skillsLabel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.ORANGE));
        gbc.ipady = 10;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        frame3.add(skillsLabel, gbc);
        mathematicsLabel = new javax.swing.JLabel();
        mathematicsLabel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.PINK));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        frame3.add(mathematicsLabel, gbc);
        scienceLabel = new javax.swing.JLabel();
        scienceLabel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.CYAN));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        frame3.add(scienceLabel, gbc);
        computerScienceLabel = new javax.swing.JLabel();
        computerScienceLabel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.green));
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        frame3.add(computerScienceLabel, gbc);
        geographyLabel = new javax.swing.JLabel();
        geographyLabel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.RED));
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        frame3.add(geographyLabel, gbc);
        historyLabel = new javax.swing.JLabel();
        historyLabel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.BLACK));
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        frame3.add(historyLabel, gbc);
        gbc.ipady = 30;
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 4;
        frame3.add(exitApplication, gbc);

        gbc.ipady = 10;
        careersLabel = new javax.swing.JLabel("CAREER PROSPECTS", SwingConstants.RIGHT);
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        frame3.add(careersLabel, gbc);
        secondColMaths = new javax.swing.JLabel("Scientist, Lecturer, Bla bla, NASA, INTEL, Bla Bla", SwingConstants.RIGHT);
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        frame3.add(secondColMaths, gbc);
        secondColScience = new javax.swing.JLabel("Scientist, Lecturer,", SwingConstants.RIGHT);
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        frame3.add(secondColScience, gbc);
        secondColCompScience = new javax.swing.JLabel("Scientist, Lecturer, NASA, INTEL", SwingConstants.RIGHT);
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        frame3.add(secondColCompScience, gbc);
        secondColGeography = new javax.swing.JLabel("Scientist, Lecturer, NASA", SwingConstants.RIGHT);
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        frame3.add(secondColGeography, gbc);
        secondColHistory = new javax.swing.JLabel("Scientist, Lecturer", SwingConstants.RIGHT);
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        frame3.add(secondColHistory, gbc);


        // Adds the fields to the panel
        // Adds all the panels to the container
        welcome.add(loading);
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
        saveCareerProspects.addActionListener(this);
        exitApplication.addActionListener(this);


        // Starts up the UI
        startGui();
        print();
    }


    // Initiates the window to display it

    public void startGui() {
/* // splash screen/welcome loading screen
        spalshScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets default close operation (when user clicks X)
        spalshScreen.setSize(1000, 750); // Sets a default window size.
        spalshScreen.setVisible(true); // Sets the window to be visible.
*/
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

            mathematicsLabel.setText(getMathematics());
            scienceLabel.setText(getScience());
            computerScienceLabel.setText(getComputerScience());
            historyLabel.setText(getHistory());
            geographyLabel.setText(getGeography());

            frame.setVisible(false);
            frame2.setVisible(false);
            frame3.setVisible(true);
        } else if (e.getActionCommand() == "Save career prospects") {

            try {
                Formatter output = new Formatter("Career.txt");

                String prospects = "Mathematician, Scientist ";

                output.format(prospects);
                output.close();
            } catch (Exception ex) {
                System.err.println(ex);
            }

        } else if (e.getActionCommand() == "Exit application") {
            int input = JOptionPane.showOptionDialog(null, "Press CANCEL or OK to exit!", "Are you sure?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if (input == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        } else if (e.getActionCommand() == "ROLL THE DICE") {

            String name = playerName.getText();
            int randomNumber = 0;
            randomNumber = rollDice();
            doMove(randomNumber);

            String fullDetail = "Hi " + name + "," + "\n     You rolled a " + randomNumber;
            JOptionPane.showMessageDialog(null, fullDetail);

            Quiz();

            if (getPlayerPosition() >= 72) {
                mathematicsLabel.setText(getMathematics());
                scienceLabel.setText(getScience());
                computerScienceLabel.setText(getComputerScience());
                historyLabel.setText(getHistory());
                geographyLabel.setText(getGeography());

                frame.setVisible(false);
                frame2.setVisible(false);
                frame3.setVisible(true);
            }
        }
    }

}


