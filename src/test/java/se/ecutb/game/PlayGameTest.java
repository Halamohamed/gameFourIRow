package se.ecutb.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayGameTest {
    FourIRow cut;
    PlayGame playGame;

    @BeforeEach
    void setUp() {
        playGame = new PlayGame();
        cut = new FourIRow();
        cut.board = new String[][]{ {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""}};
        playGame.myBoard = cut.board;

    }

    @Test
    void test_verticalWinner() throws Exception {
        assertFalse(playGame.verticalWinner());

        cut.setIColumn(1,"X");
        cut.setIColumn(1,"X");
        cut.setIColumn(1,"X");
        cut.setIColumn(1,"X");
        assertEquals( "X",playGame.myBoard[5][1]);
        assertEquals( "X",playGame.myBoard[4][1]);
        assertEquals( "X", playGame.myBoard[3][1]);
        assertEquals( "X",playGame.myBoard[2][1]);
        assertTrue(playGame.verticalWinner());
        assertEquals("X", playGame.winnerGame());
    }
    @Test
    void test_horizontalWinner() throws Exception {
        assertFalse(playGame.horizontalWinner());
        cut.setIColumn(0,"O");
        cut.setIColumn(1,"O");
        cut.setIColumn(2,"O");
        cut.setIColumn(3,"O");
        assertEquals( "O",playGame.myBoard[5][0]);
        assertEquals( "O",playGame.myBoard[5][1]);
        assertEquals( "O",playGame.myBoard[5][2]);
        assertEquals( "O",playGame.myBoard[5][3]);
        assertTrue(playGame.horizontalWinner());
        assertEquals("O", playGame.winnerGame());
    }
    @Test
    void test_diagonalWinner() throws Exception {
        assertFalse(playGame.diagonalWinner());
        cut.board = new String[][]{ {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","O","O","O"},
                {"","","","O","X","X","O"},
                {"","","O","O","O","X","X"},
                {"","O","O","X","O","O","O"}};
        playGame.myBoard = cut.board;
        assertTrue(playGame.diagonalWinner());
        assertEquals("O", playGame.winnerGame());
        cut.setIColumn(0,"X");
        cut.setIColumn(1,"X");
        cut.setIColumn(2,"X");
        cut.setIColumn(3,"X");

        assertEquals( "X",playGame.myBoard[5][0]);
        assertEquals( "X",playGame.myBoard[4][1]);
        assertEquals( "X",playGame.myBoard[3][2]);
        assertEquals( "X",playGame.myBoard[2][3]);
        assertTrue(playGame.diagonalWinner());
        assertEquals("X", playGame.winnerGame());

    }
    @Test
    void test_compare() throws Exception {

        StringBuilder stringO = new StringBuilder("OOOO");
        StringBuilder stringX = new StringBuilder("XXXX");
        StringBuilder stringF = new StringBuilder("XOXX");
        assertTrue(playGame.compare(stringO));
        assertTrue(playGame.compare(stringX));
        assertFalse(playGame.compare(stringF));
    }
    @Test
    void test_gameOver() throws Exception {
        assertFalse(playGame.gameOver());
        playGame.myBoard = new String[][]{ {"X","O","O","O","X","O","X"},
                {"X","O","O","O","X","O","X"},
                {"O","O","X","X","O","O","O"},
                {"O","X","X","O","O","O","O"},
                {"X","O","X","X","O","X","O"},
                {"X","O","X","O","X","O","O"}};

        assertTrue(playGame.gameOver());

    }
}
