package se.ecutb.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayGameTest {
    FourIRow cut;
    PlayGame playGame;
    @BeforeEach
    void setUp() {
        playGame = new PlayGame(2);
        cut = new FourIRow();
        cut.board = new String[][]{ {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""}};
    }

    @Test
    void test_verticalWinner() throws Exception {
        assertFalse(playGame.verticalWinner());

        cut.setIColumn(1,"X");
        cut.setIColumn(1,"X");
        cut.setIColumn(1,"X");
        cut.setIColumn(1,"X");
        assertEquals( "X",cut.board[5][1]);
        assertEquals( "X",cut.board[4][1]);
        assertEquals( "X",cut.board[3][1]);
        assertEquals( "X",cut.board[2][1]);
    }
    @Test
    void test_horizontalWinner() throws Exception {
        assertFalse(playGame.horizontalWinner());
        cut.setIColumn(0,"O");
        cut.setIColumn(1,"O");
        cut.setIColumn(2,"O");
        cut.setIColumn(3,"O");
        assertEquals( "O",cut.board[5][0]);
        assertEquals( "O",cut.board[5][1]);
        assertEquals( "O",cut.board[5][2]);
        assertEquals( "O",cut.board[5][3]);
    }
    @Test
    void test_diagonalWinner() throws Exception {
        cut.board = new String[][]{ {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","O","O","O"},
                {"","","","O","O","O","O"},
                {"","","O","O","O","O","O"},
                {"","O","O","O","O","O","O"}};
        assertFalse(playGame.diagonalWinner());
        cut.setIColumn(0,"X");
        cut.setIColumn(1,"X");
        cut.setIColumn(2,"X");
        cut.setIColumn(3,"X");
        assertEquals( "X",cut.board[5][0]);
        assertEquals( "X",cut.board[4][1]);
        assertEquals( "X",cut.board[3][2]);
        assertEquals( "X",cut.board[2][3]);
    }
    @Test
    void test_compare() throws Exception {
        cut.board = new String[][]{ {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","O","O","O"},
                {"","","","O","O","O","O"},
                {"X","O","X","X","O","X","O"},
                {"X","O","X","O","X","O","O"}};
        StringBuilder stringO = new StringBuilder("OOOO");
        StringBuilder stringX = new StringBuilder("XXXX");
        assertTrue(playGame.compare(stringO));
        assertTrue(playGame.compare(stringX));
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
        //playGame.myBoard = cut.board;

        assertTrue(playGame.gameOver());

    }
}
