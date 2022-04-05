import java.util.HashMap;

public class BowlingGame{
    private boolean gotStrike = false;
    private boolean gotSpare = false;
    private int totalScore =0;
    private int frames = 0;
    private int counter =3;
    private int counterX = 0;
    private static final HashMap<Character,Integer> scoreMap = new HashMap<>();


    public int bowl(String[] scoringArr){
        scoreMap.put('X',10);
        scoreMap.put('-',0);
        scoreMap.put('/',0);

        for(String score : scoringArr){
            char firstTry = score.charAt(0);
            if(score.length() == 1){
                evaluateFirstTry(firstTry);
            }
            else{
                char secondTry = score.charAt(1);
                evaluateFirstTry(firstTry);
                evaluateSecondTry(firstTry,secondTry);
            }
            if(counter == 0){
                counter =2;
            }
            frames++;
        }
        return totalScore;
    }

    private void evaluateFirstTry(char firstTry){
        if(gotSpare && Character.isDigit(firstTry) && frames<10) {
            totalScore += Character.getNumericValue(firstTry);
            gotSpare=false;
        }
        if(firstTry == 'X') {
            counterX++;
            totalScore += scoreMap.get(firstTry);
            gotStrike = true;

            if(counterX == 2 || counterX == 11) {
                totalScore = totalScore + 10;
            } else if (counterX > 2 && counterX < 11) {
                totalScore = totalScore + 20;
            }
        }else if(firstTry  == '-') totalScore += scoreMap.get('-');
        else if(gotStrike && counter>0 && Character.isDigit(firstTry)){
            totalScore += Character.getNumericValue(firstTry)*2 ;
            counter--;
        }else if(Character.isDigit(firstTry)){
            totalScore += Character.getNumericValue(firstTry);
        }
    }

    private void evaluateSecondTry(char firstTry, char secondTry){
        if(secondTry=='-') totalScore += scoreMap.get('-');
        if(secondTry == '/'){
            gotSpare = true;
            totalScore += (10-Character.getNumericValue(firstTry));
        }
        else if(gotStrike && counter>0){
            if(Character.isDigit(secondTry)){
                totalScore = totalScore + Character.getNumericValue(secondTry)*2 ;
            }
            gotStrike=false;
            counter--;
        }else if(Character.isDigit(secondTry)) totalScore += Character.getNumericValue(secondTry);
    }
}
