package se.ecutb.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class GameApplicationTests {
    FourIRow cut;
    @BeforeEach
    void setUp() {
         cut = new FourIRow();
         cut.board = new String[][]{ {"","","","","","",""},
                 {"","","","","","",""},
                 {"","","","","","",""},
                 {"","","","","","",""},
                 {"","","","","","",""},
                 {"","","","","","",""}};
    }

    @Test
    void test_nextPlayerX() {
        cut.nextPlayer();
        assertEquals("X",cut.nextPlayer());
    }
    @Test
    void test_nextPlayerO() {
        assertEquals("O",cut.nextPlayer());
    }
    @Test
    void test_setIColumn1() throws Exception {
        cut.setIColumn(1,"X");
        assertEquals("X", cut.board[5][1]);
    }
    @Test
    void test_setIColumnThrowException() {
        assertThrows(Exception.class, () -> cut.setIColumn(8,"X"));
    }

}
