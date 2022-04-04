import java.util.HashMap;

public class RomanNumeralsToDigit {

    public String convertRomanNumeralsToDigit(String romanNumeral){
        HashMap<Character,Integer> numeralMap = new HashMap<>();
        numeralMap.put('I',1);
        numeralMap.put('V',5);
        int digit = 0;

        for(char numeral : romanNumeral.toCharArray()){
            if(numeralMap.containsKey(numeral)){
                digit+=numeralMap.get(numeral);
            }
        }

        return String.valueOf(digit);
    }
}
