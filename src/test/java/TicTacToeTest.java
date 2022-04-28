import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @Test
    @DisplayName("This test checks for an open board")
    public void testOpenBoard(){
        TicTacToe ticObj = new TicTacToe();
        int[][] board = {{0,0,0}, {0,0,0}, {0,0,0}};
        int expected = -1;
        int actual = ticObj.check(board);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("This test should result in player 1 winning")
    public void testTopRowAll1(){
        TicTacToe ticObj = new TicTacToe();
        int[][] board = {{1,1,1}, {0,0,0}, {0,0,0}};
        int expected = 1;
        int actual = ticObj.check(board);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("This test should result in player 2 winning")
    public void testSecondRowAll2(){
        TicTacToe ticObj = new TicTacToe();
        int[][] board = {{1,0,0}, {2,2,2}, {0,0,0}};
        int expected = 2;
        int actual = ticObj.check(board);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("This test should result in player 2 winning col 0")
    public void testFirstColAll2(){
        TicTacToe ticObj = new TicTacToe();
        int[][] board = {{2,0,0}, {2,2,0}, {2,0,0}};
        int expected = 2;
        int actual = ticObj.check(board);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("This test should result in player 1 winning col 1")
    public void testSecondColAll1(){
        TicTacToe ticObj = new TicTacToe();
        int[][] board = {{2,1,0}, {2,1,0}, {0,1,0}};
        int expected = 1;
        int actual = ticObj.check(board);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("This test should result in player 1 winning top left diagonal")
    public void testPrincipalDiagonalTopLeftAll1(){
        TicTacToe ticObj = new TicTacToe();
        int[][] board = {{1,0,0}, {0,1,0}, {0,0,1}};
        int expected = 1;
        int actual = ticObj.checkDiagonal(board);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("This test should result in player 1 winning top left diagonal")
    public void testSecondaryDiagonalTopRightAll1(){
        TicTacToe ticObj = new TicTacToe();
        int[][] board = {{0,0,1}, {0,1,0}, {1,0,0}};
        int expected = 1;
        int actual = ticObj.checkDiagonal(board);
        assertEquals(expected, actual);
    }


}
