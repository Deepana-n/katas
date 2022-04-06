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
                counter--;
            }
            else{
                char secondTry = score.charAt(1);
                evaluateFirstTry(firstTry);
                evaluateSecondTry(firstTry,secondTry);
            }
            if(counter == 0){
                counter =2;
                gotStrike =false;
            }
            frames++;
        }
        return totalScore;
    }

    private void evaluateFirstTry(char firstTry){
        if(gotSpare && frames<10) {
            if(scoreMap.containsKey(firstTry)){
                totalScore += scoreMap.get(firstTry);
            }else{
                totalScore += Character.getNumericValue(firstTry);
            }
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

        }else if(gotStrike && counter==2){
            if(Character.isDigit(firstTry)){
                totalScore += Character.getNumericValue(firstTry)*2 ;
            }else{
                totalScore += scoreMap.get(firstTry)*2 ;
            }
            counter--;
        }else if(firstTry  == '-'){
            totalScore += scoreMap.get('-');
            System.out.println(totalScore);
        }else if(Character.isDigit(firstTry)){
            totalScore += Character.getNumericValue(firstTry);
        }
    }

    private void evaluateSecondTry(char firstTry, char secondTry){
        if(gotStrike && counter==1){
            if(secondTry == '/'){
                gotSpare = true;
                totalScore += (10-Character.getNumericValue(firstTry))*2;
            }else if(Character.isDigit(secondTry)){
                totalScore = totalScore + Character.getNumericValue(secondTry)*2 ;
            }
            gotStrike=false;
            counter--;
        }else if(secondTry=='-') totalScore += scoreMap.get('-');
        else if(secondTry == '/'){
            gotSpare = true;
            if(scoreMap.containsKey(firstTry)){
                totalScore += 10;
            }else{
                totalScore += (10-Character.getNumericValue(firstTry));
            }
        }else if(Character.isDigit(secondTry)) totalScore += Character.getNumericValue(secondTry);
    }
}
