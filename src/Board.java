import javax.swing.*;
import java.awt.*;

public class Board {

//    todo manage the board here

    public final String LEFT="LEFT", RIGHT="RIGHT", TOP="TOP", BOTTOM="BOTTOM";

    private JButton[][] gameBoard;

    private int square, stage, activeSquare;
//    square = the position on the board; when reaching 40 it means it finished the first stage
//    stage = there will be two stages: 1 - College, 2 - University. When the stage increases, the difficulty increases as well.


    public Board() {

        gameBoard = new JButton[10][10];

    }

    public int rollDice() {
        int number = (int) Math.floor(Math.random() * 6) + 1;

        //todo need to make the player move "number" tiles further

        return number;
    }

    public void doActiveTile(JButton activeTile){

        activeTile.setText("Player");
//        activeTile.setIcon(new javax.swing.ImageIcon("images//character.png"));

    }

    public void addToList(JButton createdTile, String list){

        //todo might need to add I and J in the method, or make a list instead of a matrix

        if(list.equals(LEFT)){

        }else if(list.equals(RIGHT)){

        }else if(list.equals(TOP)){

        }else if(list.equals(BOTTOM)){

        }



    }

}
