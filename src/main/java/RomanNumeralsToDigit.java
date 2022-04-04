import java.util.HashMap;

public class RomanNumeralsToDigit {

    public String convertRomanNumeralsToDigit(String romanNumeral){
        HashMap<Character,Integer> numeralMap = new HashMap<>();
        numeralMap.put('I',1);
        numeralMap.put('V',5);
        numeralMap.put('X',10);
        int digit = 0;

       for(int i =0; i<romanNumeral.length()-1;i++){
           char cur = romanNumeral.charAt(i);
           char next = romanNumeral.charAt(i+1);
            if(numeralMap.get(cur) < numeralMap.get(next)) {
                digit -= numeralMap.get(cur);
            }else{
                digit += numeralMap.get(cur);
            }
        }

       int lastCharacterValue = numeralMap.get(romanNumeral.charAt(romanNumeral.length()-1));

        return String.valueOf(digit+lastCharacterValue);
    }
}
