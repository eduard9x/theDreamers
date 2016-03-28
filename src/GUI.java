import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
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

    String[] mathematicsCareer = {"Apprenticeship in accounting", "Accountant Apprentice", "Teacher", "Statistician", "Finance analyst", "Investment manager", "Actuarial analyst"};
    String[] historyCareer = {"Exhibition guide", "Academic librarian", "Journalist", "Museum/gallery curator", "Heritage manager", "Archivist", "Archaeologist"};
    String[] geographyCareer = {"Join the army", "Tourism officer", "Secondary school teacher", "Environmental consultant", "Residential surveyor", "Landscape architect", "Cartographer"};
    String[] scienceCareer = {"Laboratory technician apprentice", "Pharmacist" ,"Healthcare scientist" ,"Research scientist" ,"Forensics" ,"Pharmacologist" ,"Biochemistry" };
    String[] computerScienceCareer = {"IT sales apprenticeship", "Software engineer", "Database administrator", "Web developer", "Systems analyst", "Application developer", "IT developer"};

    //Buttons for frame
    JButton howToPlay, playButton, exitButton; // The buttons for "Throw", "Score" and "New Game"
    // buttons for frame 2
    JButton quitEducation, rollDice;
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
        quitEducation = new JButton("Quit education");
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
        container2.setBackground(Color.WHITE);

        frame2.setContentPane(container2);
        //container for frame 3
        JPanel container3 = new JPanel();
        container3.setBackground(Color.WHITE);
        frame3.setContentPane(container3);

        loading = new javax.swing.JLabel();
        loading.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("images/hexLoader.gif")));

        // start panel with play button and exit button
        // for frame

        playerName = new javax.swing.JTextField();
        playerName.setText("Player");
        playerName.setLocation(100, 100);
        playerName.setPreferredSize(new Dimension(100, 100));
        playerName.setHorizontalAlignment(JTextField.CENTER);

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
        start.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("images/logo2.png")));

        //for frame 2
        JPanel frame2 = new JPanel();
        frame2.add(quitEducation);

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

        /* adding constraints for roll dice and Quit education */
        gbc.ipady = 30;
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        frame2.add(rollDice, gbc); //add in the frame


        gbc.ipady = 30;
        gbc.gridx = 6;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        frame2.add(quitEducation, gbc); //add in the frame
        /* END OF adding constraints for roll dice and Quit education */


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

        frame3.setBackground(Color.WHITE);

        skillsLabel = new javax.swing.JLabel("SKILLS");
        skillsLabel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.ORANGE));
        Font font = skillsLabel.getFont();
        // same font but bold
        int fontSize = font.getSize();
        fontSize +=5;
        Font boldFont = new Font(font.getFontName(), Font.BOLD, fontSize);
        skillsLabel.setFont(boldFont);

        gbc.ipady = 10;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        frame3.add(skillsLabel, gbc);
        mathematicsLabel = new javax.swing.JLabel();
        mathematicsLabel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.PINK));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        frame3.add(mathematicsLabel, gbc);
        scienceLabel = new javax.swing.JLabel();
        scienceLabel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.CYAN));
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        frame3.add(scienceLabel, gbc);
        computerScienceLabel = new javax.swing.JLabel();
        computerScienceLabel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.green));
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        frame3.add(computerScienceLabel, gbc);
        geographyLabel = new javax.swing.JLabel();
        geographyLabel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.RED));
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        frame3.add(geographyLabel, gbc);
        historyLabel = new javax.swing.JLabel();
        historyLabel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.BLACK));
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        frame3.add(historyLabel, gbc);
        gbc.ipady = 30;
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 4;
        frame3.add(exitApplication, gbc);

        gbc.ipady = 10;
        careersLabel = new javax.swing.JLabel("CAREER PROSPECTS", SwingConstants.RIGHT);
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        careersLabel.setFont(boldFont);

        frame3.add(careersLabel, gbc);
        secondColMaths = new javax.swing.JLabel(mathematicsCareer[0], SwingConstants.RIGHT);
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        frame3.add(secondColMaths, gbc);
        secondColScience = new javax.swing.JLabel(scienceCareer[0], SwingConstants.RIGHT);
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        frame3.add(secondColScience, gbc);
        secondColCompScience = new javax.swing.JLabel(computerScienceCareer[0] , SwingConstants.RIGHT);
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        frame3.add(secondColCompScience, gbc);
        secondColGeography = new javax.swing.JLabel(geographyCareer[0], SwingConstants.RIGHT);
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        frame3.add(secondColGeography, gbc);
        secondColHistory = new javax.swing.JLabel(historyCareer[0] , SwingConstants.RIGHT);
        gbc.gridx = 3;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        frame3.add(secondColHistory, gbc);

        JLabel skills = new javax.swing.JLabel();
        skills.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("images/small.jpg")));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 9;
        gbc.gridwidth = 3;
        frame3.add(skills, gbc);

        JLabel backgroundImage = new javax.swing.JLabel();
        backgroundImage.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("images/logoSmall.jpg")));
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridheight = 2;
        gbc.gridwidth = 3;
        frame2.setBackground(Color.WHITE);
        frame2.add(backgroundImage, gbc);


        JLabel rollDiceImage = new javax.swing.JLabel();
        rollDiceImage.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("images/rollDice.jpg")));
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridheight = 3;
        gbc.gridwidth = 3;
        frame2.add(rollDiceImage, gbc);


        JLabel quitEducationImage = new javax.swing.JLabel();
        quitEducationImage.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("images/quitEducation.jpg")));
        gbc.gridx = 6;
        gbc.gridy = 5;
        gbc.gridheight = 3;
        gbc.gridwidth = 3;
        frame2.add(quitEducationImage, gbc);

        exitApplication.setFont(boldFont);
        saveCareerProspects.setFont(boldFont);
        saveCareerProspects.setForeground(Color.ORANGE);
        exitApplication.setBackground(Color.BLACK);
        exitApplication.setForeground(Color.RED);
        Border border = new LineBorder(Color.LIGHT_GRAY, 5);
        exitApplication.setBorder(border);
        saveCareerProspects.setBorder(border);
        start.setBorder(border);
        howToPlay.setBorder(border);
        playButton.setBorder(border);
        exitButton.setBorder(border);
        howToPlay.setFont(boldFont);
        playButton.setFont(boldFont);
        exitButton.setFont(boldFont);
        border = new LineBorder(Color.ORANGE, 5);
        playerName.setBorder(border);

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
        quitEducation.addActionListener(this);
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

            Board gameBoard = new Board();

            frame2.setVisible(true);
            frame.setVisible(false);
        } else if (e.getActionCommand() == "HOW TO PLAY") {
            Icon Instructions =  new ImageIcon(getClass().getClassLoader().getResource("images/instructions.jpg"));
            JOptionPane.showMessageDialog(null, "<html><body><h1>How to play the game</h1><h3>| Roll the dice </h3><h3>| Answer questions </h3><h3>| Earn skills</h3><h3>--- Repeat until you graduate</h3><h3>--- Get career prospects based on your skills</h3><h3>--- Save the career prospects for further use</h3></body></html>", "Game Instructions" , JOptionPane.INFORMATION_MESSAGE, Instructions);
        } else if (e.getActionCommand() == "QUIT") {

            int input = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if (input == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        } else if (e.getActionCommand() == "Quit education") {

            doCareerProspects();

            frame.setVisible(false);
            frame2.setVisible(false);
            frame3.setVisible(true);
        } else if (e.getActionCommand() == "Save career prospects") {

            try {
                Formatter output = new Formatter("Career.txt");

                StringBuilder myCareersToBeSaved = new StringBuilder();
                myCareersToBeSaved.append("You might enjoy and be successful in one of the following careers: " + "\n\n");

                myCareersToBeSaved.append(mathematicsCareer[getMathematicsValue()] + "\n");
                myCareersToBeSaved.append(historyCareer[getHistoryValue()] + "\n");
                myCareersToBeSaved.append(geographyCareer[getGeographyValue()] + "\n");
                myCareersToBeSaved.append(computerScienceCareer[getComputerScienceValue()] + "\n");
                myCareersToBeSaved.append(scienceCareer[getScienceValue()] + "\n");

                output.format(myCareersToBeSaved.toString());
                output.close();
            } catch (Exception ex) {
                System.err.println(ex);
            }

            Icon saved =  new ImageIcon(getClass().getClassLoader().getResource("images/saved.png"));
            int input = JOptionPane.showOptionDialog(null, "Career prospects have been saved! \n Do you want to exit?", "Career prospects saved", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, saved, null, null);
            if (input == JOptionPane.OK_OPTION) {
                System.exit(0);
            }

        } else if (e.getActionCommand() == "Exit application") {
            Icon leaving =  new ImageIcon(getClass().getClassLoader().getResource("images/leaving.png"));

            int input = JOptionPane.showOptionDialog(null, "Press CANCEL or OK to exit!", "Are you sure?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, leaving, null, null);
            if (input == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        } else if (e.getActionCommand() == "ROLL THE DICE") {

            String name = playerName.getText();
            int randomNumber;
            randomNumber = rollDice();
            doMove(randomNumber);

            final ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/dices.gif"));
            String fullDetail = "Hi " + name + "," + "\n     You rolled a " + randomNumber;
            JOptionPane.showMessageDialog(null, fullDetail, "Rolled dice" , JOptionPane.INFORMATION_MESSAGE, icon);

            Quiz();

            if (getPlayerPosition() >= 72) {
                doCareerProspects();

                frame.setVisible(false);
                frame2.setVisible(false);
                frame3.setVisible(true);
            }
        }
    }

    public void doCareerProspects(){
        mathematicsLabel.setText(getMathematics());
        scienceLabel.setText(getScience());
        computerScienceLabel.setText(getComputerScience());
        historyLabel.setText(getHistory());
        geographyLabel.setText(getGeography());

        secondColMaths.setText(mathematicsCareer[getMathematicsValue()]);
        secondColHistory.setText(historyCareer[getHistoryValue()]);
        secondColGeography.setText(geographyCareer[getGeographyValue()]);
        secondColCompScience.setText(computerScienceCareer[getComputerScienceValue()]);
        secondColScience.setText(scienceCareer[getScienceValue()]);
    }

}


