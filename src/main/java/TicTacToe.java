import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public int check(int[][] board) {
        int countZeroes =0;
        int countOnes =0;
        int countTwos =0;
        for(int row =0; row<board.length;row++){
            for(int col=0;col<board.length;col++){
                if(board[row][col] == 0){
                    countZeroes++;
                }else if(board[col][row] == 0){
                    countZeroes++;
                }
                if(board[row][col] == 1) countOnes++;
                else if(board[col][row] ==1) countOnes++;
                else if(row==col && board[row][col]==1) countOnes++;
                else if((row+col) == (board.length-1) && board[row][col]==1) countOnes++;

                if(board[row][col] == 2) countTwos++;
                else if(board[col][row]==2) countTwos++;
                else if(row==col && board[row][col]==2) countTwos++;
                else if((row+col) == (board.length-1) && board[row][col]==2) countTwos++;

            }
            if(countOnes == 3) return 1;
            else if(countTwos==3) return 2;
            else {
                countOnes = 0;
                countTwos = 0;
            }

        }
        if(countZeroes ==9) return -1;

        return -2;
    }

    public int checkDiagonal(int[][] board) {
        int countZeroes =0;
        int countPrincipalOnes =0;
        int countSecondaryOnes =0;
        int countPrincipalTwos =0;
        int countSecondaryTwos =0;
        for(int row =0; row<board.length;row++){
            for(int col=0;col<board.length;col++){
                if(row==col && board[row][col]==1) countPrincipalOnes++;
                if((row+col) == (board.length-1) && board[row][col]==1) countSecondaryOnes++;

                if(row==col && board[row][col]==2) countPrincipalTwos++;
                if((row+col) == (board.length-1) && board[row][col]==2) countSecondaryTwos++;

            }

        }
        System.out.println(countSecondaryOnes);
        System.out.println(countPrincipalOnes);
        if(countPrincipalOnes==3 || countSecondaryOnes==3) return 1;
        else if(countPrincipalTwos==3 || countSecondaryTwos==3) return 2;
        return -2;
    }


}
