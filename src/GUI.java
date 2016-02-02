/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Harvey
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GUI implements ActionListener{

    // Initiates the JFrame Object. Gives it a title.
    JFrame frame = new JFrame("Start Screen");
    JFrame frame2 = new JFrame("Game Screen");
    JFrame frame3 = new JFrame("Conlusion Screen");

    //Buttons for frame
    JButton howToPlay,playButton, exitButton; // The buttons for "Throw", "Score" and "New Game"
    // buttons for frame 2
    JButton nextFrame;
    // buttons for frame 3
    JButton goBackToMenu;



    // Text fields which are shown on the JFrame
    javax.swing.JLabel start;
    javax.swing.JLabel labelFrame2;
    javax.swing.JLabel labelFrame3;
    javax.swing.JLabel box1,box2,box3,box4,box5;



    
    JFrame message = new JFrame(); // for pop messages!

    public GUI(){

        //frame.setLayout(new FlowLayout());

        // Sets the text and initiates the objects for the buttons
        playButton = new JButton("PLAY");
        exitButton = new JButton("QUIT");
        howToPlay = new JButton("HOW TO PLAY");
        nextFrame = new JButton("NEXT FRAME");
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
        //startPanel.setLayout(new BoxLayout(startPanel,BoxLayout.X_AXIS));
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
        labelFrame2 = new javax.swing.JLabel("Your in Frame 2");
        frame2.add(labelFrame2);
        frame2.add(box1);
        frame2.add(box2);
        frame2.add(box3);
        frame2.add(box4);
        frame2.add(box5);



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
        goBackToMenu.addActionListener(this);
        

        // Starts up the UI
        startGui();
    }

    // Initiates the window to display it
    public void startGui(){
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
        if(e.getActionCommand() == "PLAY"){
                frame2.setVisible(true);
            frame.setVisible(false);
        }
        else if (e.getActionCommand() == "HOW TO PLAY"){ 
                //frame2.setVisible(false);
            JOptionPane.showMessageDialog(null,"Include how to play intructions here");
        } 
        else if (e.getActionCommand() == "QUIT"){
            int input = JOptionPane.showOptionDialog(null, "Press CANCEL or OK to exit!", "Are you sure?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if(input == JOptionPane.OK_OPTION)
                {
                    System.exit(0);
            } 
        }
        else if(e.getActionCommand() == "NEXT FRAME"){
            frame.setVisible(false);
            frame2.setVisible(false);
            frame3.setVisible(true);
        }
        else if(e.getActionCommand() == "BACK TO MENU"){
            frame.setVisible(true);
            frame2.setVisible(false);
            frame3.setVisible(false);
        }
        
    }
   
}