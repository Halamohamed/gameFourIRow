package se.ecutb.game;

import java.util.ArrayList;
import java.util.List;

public class PlayGameStub extends PlayGame {
    List<FourIRow> game;
    public PlayGameStub() {

        game = new ArrayList<FourIRow>();
    }


    public boolean verticalWinner() {
        game.add(new FourIRow());
        return false;
    }
    public boolean gameOver(){
        return false;
    }
}
