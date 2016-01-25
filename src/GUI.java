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
    JFrame frame1 = new JFrame("Start Screen");
    JFrame frame = new JFrame("Game Screen");
    
    JButton throwButton,playButton, exitButton; // The buttons for "Throw", "Score" and "New Game"

    // Text fields which are shown on the JFrame
    javax.swing.JLabel start;
    
    JFrame message = new JFrame(); // for pop messages!

    public GUI(){

        // Sets the frame layout to FlowLayout
        frame.setLayout(new FlowLayout());
        frame1.setLayout(new FlowLayout());

        // Sets the text and initiates the objects for the buttons
        playButton = new JButton("PLAY");
        exitButton = new JButton("QUIT");
        throwButton = new JButton("HOW TO PLAY");

        // Buttons Panel which holds all the buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel,BoxLayout.X_AXIS)); // BoxLayout for all the buttons
        // Adds all the buttons to the panel
 
        
        // start panel with play button and exit button
        JPanel startPanel = new JPanel();
        //startPanel.setLayout(new BoxLayout(startPanel,BoxLayout.X_AXIS));
        startPanel.add(playButton);
        playButton.setPreferredSize(new Dimension(200, 100));
        startPanel.add(exitButton);
        exitButton.setPreferredSize(new Dimension(200, 100));
        

        // The main container for the JFrame
        JPanel container = new JPanel();
        
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS)); // Box Layout for JPanel Container
        container.setBackground(Color.RED);
        frame.setContentPane(container);
        
        JPanel container2 = new JPanel();
        frame1.setContentPane(container2);
        
        start = new javax.swing.JLabel();
        //frame 1 animation of the dices
        //start.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/bg.png")));
        
        // Adds the fields to the panel
        // Adds all the panels to the container
        container2.add(start);
        
        //adds start panel
        container2.add(startPanel);

        // Action Listeners for the buttons
        throwButton.addActionListener(this);
        
        //frame 1 buttons PLAY AND EXIT
        playButton.addActionListener(this);
        exitButton.addActionListener(this);
        

        // Starts up the UI
        startGui();
    }

    // Initiates the window to display it
    public void startGui(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets default close operation (when user clicks X)
        frame.setSize(1000, 700); // Sets a default window size.
        frame.setVisible(true); // Sets the window to be visible.
        
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets default close operation (when user clicks X)
        frame1.setSize(1000, 700); // Sets a default window size.
        frame1.setVisible(true);
    }

    // Code behind the buttons. This is called when the 4 buttons are clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        //play button
        if(e.getActionCommand() == "PLAY"){
                frame1.setVisible(false);
        }
        else if (e.getActionCommand() == "HOW TO PLAY"){ 
                //frame2.setVisible(false);
        } 
        else if (e.getActionCommand() == "QUIT"){
            int input = JOptionPane.showOptionDialog(null, "Press CANCEL or OK to exit!", "Are you sure?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if(input == JOptionPane.OK_OPTION)
                {
                    System.exit(0);
            } 
        }
        
    }
   
}