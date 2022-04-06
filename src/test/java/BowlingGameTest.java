import org.junit.jupiter.api.Test;

/*Suggested Test Cases

(When scoring “X” indicates a strike, “/” indicates a spare, “-” indicates a miss)

X X X X X X X X X X X X (12 rolls: 12 strikes) = 10 frames * 30 points = 300
9- 9- 9- 9- 9- 9- 9- 9- 9- 9- (20 rolls: 10 pairs of 9 and miss) = 10 frames * 9 points = 90
5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5 (21 rolls: 10 pairs of 5 and spare, with a final 5) = 10 frames * 15 points = 150

 */

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    @Test
    public void checkForPlayerScore(){
        //arrange
        BowlingGame bowlingObj = new BowlingGame();
        String[] scoringArr =  {"--","--","--","--","--","--","--","--","--","--"};
        //act
        int actual = bowlingObj.bowl(scoringArr);
        //assert
        assertEquals(0,actual);
    }

    @Test
    public void checkForOneStrike(){
        //arrange
        BowlingGame bowlingObj = new BowlingGame();
        String[] scoringArr =  {"X","--","--","--","--","--","--","--","--","--"};
        //act
        int actual = bowlingObj.bowl(scoringArr);
        //assert
        assertEquals(10,actual);
    }

    @Test
    public void checkOneFrameOf9(){
        //arrange
        BowlingGame bowlingObj = new BowlingGame();
        String[] scoringArr =  {"9-","--","--","--","--","--","--","--","--","--"};
        //act
        int actual = bowlingObj.bowl(scoringArr);
        //assert
        assertEquals(9,actual);
    }

    @Test
    public void checkOneSpare(){
        //arrange
        BowlingGame bowlingObj = new BowlingGame();
        String[] scoringArr =  {"9/","--","--","--","--","--","--","--","--","--"};
        //act
        int actual = bowlingObj.bowl(scoringArr);
        //assert
        assertEquals(10,actual);
    }

    @Test
    public void checkOneStrikeAnd2SameScores(){
        //arrange
        BowlingGame bowlingObj = new BowlingGame();
        String[] scoringArr =  {"X","5-","5-","--","--","--","--","--","--","--"};
        //act
        int actual = bowlingObj.bowl(scoringArr);
        //assert
        assertEquals(25,actual);
    }

    @Test
    public void checkOneStrikeAnd2DifferentScores(){
        //arrange
        BowlingGame bowlingObj = new BowlingGame();
        String[] scoringArr =  {"X","5-","2-","--","--","--","--","--","--","--"};
        //act
        int actual = bowlingObj.bowl(scoringArr);
        //assert
        assertEquals(22,actual);
    }

    @Test
    public void checkOneStrikeInSecondFrameAnd2DifferentScores(){
        //arrange
        BowlingGame bowlingObj = new BowlingGame();
        String[] scoringArr =  {"--","X","5-","2-","--","--","--","--","--","--"};
        //act
        int actual = bowlingObj.bowl(scoringArr);
        //assert
        assertEquals(22,actual);
    }

    @Test
    public void checkOneStrikeInThirdFrameAnd1Miss1Score(){
        //arrange
        BowlingGame bowlingObj = new BowlingGame();
        String[] scoringArr =  {"--","--","X","--","2-","--","--","--","--","--"};
        //act
        int actual = bowlingObj.bowl(scoringArr);
        //assert
        assertEquals(12,actual);
    }

    @Test
    public void check10PairsOf9AndMiss(){
        //arrange
        BowlingGame bowlingObj = new BowlingGame();
        String[] scoringArr =  {"9-","9-","9-","9-","9-","9-","9-","9-","9-","9-"};
        //act
        int actual = bowlingObj.bowl(scoringArr);
        //assert
        assertEquals(90,actual);
    }

    @Test
    public void check2FramesOfStrikesAndRestMisses(){
        //arrange
        BowlingGame bowlingObj = new BowlingGame();
        String[] scoringArr =  {"X","X","--","--","--","--","--","--","--","--"};
        //act
        int actual = bowlingObj.bowl(scoringArr);
        //assert
        assertEquals(30,actual);
    }

    @Test
    public void checkAllStrikes(){
        //arrange
        BowlingGame bowlingObj = new BowlingGame();
        String[] scoringArr =  {"X","X","X","X","X","X","X","X","X","X","X","X"};
        //act
        int actual = bowlingObj.bowl(scoringArr);
        //assert
        assertEquals(300,actual);
    }

    @Test
    public void check10PairsOf5AndASparePlusFinal5(){
        //arrange
        BowlingGame bowlingObj = new BowlingGame();
        String[] scoringArr =  {"5/","5/","5/","5/","5/","5/","5/","5/","5/","5/", "5"};
        //act
        int actual = bowlingObj.bowl(scoringArr);
        //assert
        assertEquals(150,actual);
    }

    @Test
    public void check10PairsOf1(){
        //arrange
        BowlingGame bowlingObj = new BowlingGame();
        String[] scoringArr =  {"11","11","11","11","11","11","11","11","11","11"};
        //act
        int actual = bowlingObj.bowl(scoringArr);
        //assert
        assertEquals(20,actual);
    }

    @Test
    public void CheckRandomPairs(){
        //arrange
        BowlingGame bowlingObj = new BowlingGame();
        String[] scoringArr =  { "8/", "5/", "42", "-7", "51", "2-", "X", "16", "31", "53"};
        //act
        int actual = bowlingObj.bowl(scoringArr);
        //assert
        assertEquals(86,actual);
    }

    @Test
    public void CheckRandomPairs2(){
        //arrange
        BowlingGame bowlingObj = new BowlingGame();
        //act
        String[] scoringArr =  {"5/", "4/", "3/", "2/", "1/", "-/", "X", "9/", "4/", "8/","8"};
        // 14 13 12 11 10 20 20 14 18 18
        int actual = bowlingObj.bowl(scoringArr);
        //assert
        assertEquals(150,actual);

    }

}
