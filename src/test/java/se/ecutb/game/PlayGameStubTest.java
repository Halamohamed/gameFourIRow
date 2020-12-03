package se.ecutb.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayGameStubTest {
    FourIRow cut ;
    PlayGameStub stub ;
    PlayGame game;
    @BeforeEach
    void setup() throws Exception {
         cut = new FourIRow();
         stub = new PlayGameStub();
         game = new PlayGame();
        /* game.myBoard = new String[][]{ {"","","","","","",""},
                 {"","","","","","",""},
                 {"","","","","","",""},
                 {"","","","","","",""},
                 {"","","","","","",""},
                 {"","","","","","",""}};*/
        game.setInCol("X", 1);
        game.setInCol("X", 1);
        game.setInCol("X", 1);
        game.setInCol("X", 1);
        cut.board = game.myBoard;
        //game.myBoard = cut.board;

         stub.addGame(cut);
    }

    @Test
    void test_verticalWinner() throws Exception {
        assertFalse(stub.verticalWinner());
    }
}
