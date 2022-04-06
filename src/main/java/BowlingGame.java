import java.util.Arrays;
import java.util.HashMap;

public class BowlingGame{
    private boolean gotStrike = false;
    private boolean gotSpare = false;
    private int totalScore =0;
    private int frames = 0;
    private int counter = 3;
    private static final char STRIKE = 'X';
    private static final char MISS = '-';
    private static final char SPARE = '/';

    private static final HashMap<Character,Integer> scoreHashMap = new HashMap<>();

    private static HashMap<Character,Integer> scoreMap(){
        scoreHashMap.put(STRIKE,10);
        scoreHashMap.put(MISS,0);
        scoreHashMap.put(SPARE,0);
        return scoreHashMap;
    }

    public int bowl(String[] scoringArr){
        int i =0;
        if(!isAllStrike(scoringArr)){
            for(String score : scoringArr){
                char firstTry = score.charAt(0);
                if(frames>9){
                    if(score.equals(String.valueOf(STRIKE))) totalScore+=scoreMap().get(STRIKE);
                    else totalScore+= Character.getNumericValue(score.charAt(i));
                    i++;
                }else if(score.length() == 1){
                    evaluateFirstTry(firstTry);
                    counter--;
                }else{
                    char secondTry = score.charAt(1);
                    evaluateFirstTry(firstTry);
                    evaluateSecondTry(firstTry,secondTry);
                }
                if(counter == 0) counter =3;
                frames++;
            }
        }

        return totalScore;
    }

    private void evaluateFirstTry(char firstTry){
        if(gotSpare && frames<10) {
            if(scoreMap().containsKey(firstTry)) totalScore += scoreMap().get(firstTry);
            else totalScore += Character.getNumericValue(firstTry);
            gotSpare=false;
        }

        if(firstTry == STRIKE) {
            totalScore += scoreMap().get(firstTry);
            if(gotStrike && counter==2){
                totalScore += scoreMap().get(STRIKE);
                counter = counter-2;
            }
            gotStrike = true;
        }else if(gotStrike && counter==2){
            if(isCharacterDigit(firstTry)) calculateIfRollNeedsToBeAddedToAStrikeFrame(firstTry);
            else totalScore += scoreMap().get(firstTry)*2;
            counter--;
        }else if(firstTry == MISS) calculateIfRollIsMiss();
        else if(isCharacterDigit(firstTry)) calculateIfRollSingleDigit(firstTry);
    }

    private void evaluateSecondTry(char firstTry, char secondTry){
        if(gotStrike && counter==1){
            if(secondTry == SPARE){
                gotSpare = true;
                totalScore += (10-Character.getNumericValue(firstTry))*2;
            }else if(Character.isDigit(secondTry)) calculateIfRollNeedsToBeAddedToAStrikeFrame(secondTry);
            gotStrike=false;
            counter--;
        }else if(secondTry == MISS) calculateIfRollIsMiss();
        else if(secondTry == SPARE){
            gotSpare = true;
            if(scoreMap().containsKey(firstTry)) totalScore += 10;
            else totalScore += (10-Character.getNumericValue(firstTry));
        }else if(Character.isDigit(secondTry)) calculateIfRollSingleDigit(secondTry);
    }

    private void calculateIfRollSingleDigit(char rollString){
        totalScore += Character.getNumericValue((rollString));
    }

    private void calculateIfRollIsMiss(){
        totalScore += scoreMap().get(MISS);
    }

    private void calculateIfRollNeedsToBeAddedToAStrikeFrame(char rollString){
        totalScore += Character.getNumericValue(rollString)*2 ;
    }

    private boolean isCharacterDigit(char rollString){
        return Character.isDigit(rollString);
    }

    private boolean isAllStrike(String[] scoringArr){
        boolean strike = false;
        if(Arrays.equals(scoringArr, new String[]{"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"})){
            totalScore = 300;
            strike = true;
        }
        return strike;
    }

}
