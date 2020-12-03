package se.ecutb.game;

import java.io.IOException;

public interface IGame {
    void start() throws IOException;
    String winnerGame();
    boolean gameOver();
}
