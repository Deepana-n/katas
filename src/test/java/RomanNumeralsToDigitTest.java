import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsToDigitTest {
    @Test
    public void convertIto1(){
        //arrange
        RomanNumeralsToDigit romanObj = new RomanNumeralsToDigit();
        //act & assert
        assertEquals("1",romanObj.convertRomanNumeralsToDigit("I"));
    }

    @Test
    public void convertIIto2(){
        //arrange
        RomanNumeralsToDigit romanObj = new RomanNumeralsToDigit();
        //act & assert
        assertEquals("2",romanObj.convertRomanNumeralsToDigit("II"));
    }

    @Test
    public void convertVIto6(){
        //arrange
        RomanNumeralsToDigit romanObj = new RomanNumeralsToDigit();
        //act & assert
        assertEquals("6",romanObj.convertRomanNumeralsToDigit("VI"));
    }

    @Test
    public void convertIVto4(){
        //arrange
        RomanNumeralsToDigit romanObj = new RomanNumeralsToDigit();
        //act & assert
        assertEquals("4",romanObj.convertRomanNumeralsToDigit("IV"));
    }

    @Test
    public void convertIXto9(){
        //arrange
        RomanNumeralsToDigit romanObj = new RomanNumeralsToDigit();
        //act & assert
        assertEquals("9",romanObj.convertRomanNumeralsToDigit("IX"));
    }

}
