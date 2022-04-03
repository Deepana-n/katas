import java.util.TreeMap;

public class RomanNumeralsDigitToNumerals {
    private static final TreeMap<Integer,String> romanLettersMap = new TreeMap<>();

    private static TreeMap<Integer,String> createRomanLettersMap(){
        romanLettersMap.put(1,"I");
        romanLettersMap.put(5,"V");
        romanLettersMap.put(10,"X");
        romanLettersMap.put(50,"L");
        romanLettersMap.put(100,"C");
        romanLettersMap.put(500,"D");
        return romanLettersMap;
    }

    public String convertDigitToRomanNumeral(int digit){
        StringBuilder romanNumeral = new StringBuilder();
        int ceilingDifference = createRomanLettersMap().ceilingKey(digit)-digit ;
        int floorDifference = Math.abs(createRomanLettersMap().floorKey(digit)-digit) ;
        if(createRomanLettersMap().containsKey(digit)){
            romanNumeral.append(createRomanLettersMap().get(digit));
        }else{
            romanNumeral.append(createRomanLettersMap().get(createRomanLettersMap().floorKey(digit)));
            int difference = floorDifference;
            while(difference > 0){
                int currentDigit = createRomanLettersMap().floorKey(difference);
                String convertCurrentDigitToRomanNumeral = createRomanLettersMap().get(currentDigit);
                romanNumeral.append(convertCurrentDigitToRomanNumeral);
                difference -= currentDigit;
            }
        }

        System.out.println(romanNumeral.toString());
        return romanNumeral.toString();
    }
}
