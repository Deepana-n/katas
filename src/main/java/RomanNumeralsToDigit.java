import java.util.HashMap;

public class RomanNumeralsToDigit {
    private static final String pattern = "(^(?=[XVI])(I[XV]|V?I{0,3})$)";
    private static final HashMap<Character,Integer> numeralMap = new HashMap<>();

    private static HashMap<Character,Integer> createdNumeralMap(){
        numeralMap.put('I',1);
        numeralMap.put('V',5);
        numeralMap.put('X',10);
        return numeralMap;
    }

    public String convertRomanNumeralsToDigit(String romanNumeral){
        if(!romanNumeral.matches(pattern)) return "Invalid roman numeral. Should not repeat same numeral 4x.";
        int digit = 0;

       for(int i =0; i<romanNumeral.length()-1;i++){
           char cur = romanNumeral.charAt(i);
           char next = romanNumeral.charAt(i+1);
            if(createdNumeralMap().get(cur) < createdNumeralMap().get(next)) {
                digit -= createdNumeralMap().get(cur);
            }else{
                digit += createdNumeralMap().get(cur);
            }
        }

       int lastCharacterValue = createdNumeralMap().get(romanNumeral.charAt(romanNumeral.length()-1));

        return String.valueOf(digit+lastCharacterValue);
    }
}
