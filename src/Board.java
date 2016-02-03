public class Board {

//    todo manage the board here

    private int square, stage, activeSquare;
//    square = the position on the board; when reaching 40 it means it finished the first stage
//    stage = there will be two stages: 1 - College, 2 - University. When the stage increases, the difficulty increases as well.


    public Board() {

    }

    public int rollDice() {
        int number = (int) Math.floor(Math.random() * 6) + 1;
        return number;
    }


}
