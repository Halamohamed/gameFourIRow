package se.ecutb.game;

import java.util.ArrayList;
import java.util.List;

public class PlayGameStub extends PlayGame {
    List<FourIRow> game;
    public PlayGameStub(int play_number) {
        super(play_number);
        game = new ArrayList<FourIRow>();
    }
}