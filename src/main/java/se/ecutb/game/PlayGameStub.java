package se.ecutb.game;

import java.util.ArrayList;
import java.util.List;

public class PlayGameStub extends PlayGame{
    List<FourIRow> game = new ArrayList<FourIRow>();
    FourIRow fourIRow ;
    PlayGame playGame;

    public PlayGameStub() {

        fourIRow = new FourIRow();
        playGame = new PlayGame();
        playGame.myBoard = fourIRow.board;
    }


    public void addGame(FourIRow fourIRow) throws Exception {

        game.add(fourIRow);

    }
    public boolean verticalWinner() {
        return false;
    }
    public boolean horizontalWinner() {
        return false;
    }
    public boolean diagonalWinner() {
        return false;
    }
    public boolean gameOver(){
        return false;
    }
    public boolean getWinner() {
        return false;
    }
    public void controlWinner() {

    }
}
