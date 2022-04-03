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
        int count = 1;
        int countDigitValue =0;
        int ceilingDifference = createRomanLettersMap().ceilingKey(digit)-digit ;
        int floorDifference = Math.abs(createRomanLettersMap().floorKey(digit)-digit) ;
        if(createRomanLettersMap().containsKey(digit)){
            romanNumeral.append(createRomanLettersMap().get(digit));
        }else{
            while(digit > 0){
                int currentDigit = createRomanLettersMap().floorKey(digit);
                countDigitValue +=currentDigit;
                String convertCurrentDigitToRomanNumeral = createRomanLettersMap().get(currentDigit);
                if(romanNumeral.length()>0 && convertCurrentDigitToRomanNumeral.equals(romanNumeral.substring(romanNumeral.length()-1))){
                    count++;
                }else{
                    count=1;
                }
                String result = checkRepeatedNumerals(count,romanNumeral,countDigitValue);
                //System.out.println(result);
                if(romanNumeral.length() >= 0 && result.isEmpty()){
                    romanNumeral.append(convertCurrentDigitToRomanNumeral);
                }else{
                    countDigitValue =0;
                    //romanNumeral.append(result);
                }
                digit -= currentDigit;
            }
        }
        return romanNumeral.toString();
    }

    public String checkRepeatedNumerals(int count,StringBuilder romanNumeral,int countDigitValue){
        StringBuilder nonRepeated = new StringBuilder();
        if (count == 4) {
            System.out.println(romanNumeral.length());
            if(romanNumeral.length() == 3){
                romanNumeral.setLength(0);
            }else{
                romanNumeral.setLength(romanNumeral.length()-4);
            }

            while(countDigitValue>0){
                int currentDigit = createRomanLettersMap().ceilingKey(countDigitValue);
                String convertCurrentDigitToRomanNumeral = createRomanLettersMap().get(currentDigit);
                nonRepeated.append(convertCurrentDigitToRomanNumeral);
                countDigitValue= Math.abs(countDigitValue-currentDigit);
            }
            return romanNumeral.append(nonRepeated.reverse()).toString();
        }
        return "";
    }
}
