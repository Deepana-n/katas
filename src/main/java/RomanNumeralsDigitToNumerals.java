import java.util.HashMap;

public class RomanNumeralsDigitToNumerals {
    private static final HashMap<Integer,String> romanLettersMap = new HashMap<>();

    private static HashMap<Integer,String> createRomanLettersMap(){
        romanLettersMap.put(1,"I");
        romanLettersMap.put(5,"V");
        romanLettersMap.put(10,"X");
        romanLettersMap.put(50,"L");
        romanLettersMap.put(100,"C");
        romanLettersMap.put(500,"D");
        return romanLettersMap;
    }

    public String convertDigitToRomanNumeral(int digit){
        String romanNumeral = "";
        if(createRomanLettersMap().containsKey(digit)){
            romanNumeral = createRomanLettersMap().get(digit);
        }
        return romanNumeral;
    }
}
