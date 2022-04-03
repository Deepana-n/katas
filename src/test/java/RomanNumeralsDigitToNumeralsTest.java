import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsDigitToNumeralsTest {

    @Test
    public void convert1ToI(){
        //act
        RomanNumeralsDigitToNumerals romanObj = new RomanNumeralsDigitToNumerals();
        //arrange
        int digit = 1;
        String actual = romanObj.convertDigitToRomanNumeral(digit);
        //assert
        assertEquals("I",actual);
    }

    @Test
    public void convert7ToVII(){
        //act
        RomanNumeralsDigitToNumerals romanObj = new RomanNumeralsDigitToNumerals();
        //arrange
        int digit = 7;
        String actual = romanObj.convertDigitToRomanNumeral(digit);
        //assert
        assertEquals("VII",actual);
    }

    @Test
    public void convert88ToLXXXVIII(){
        //act
        RomanNumeralsDigitToNumerals romanObj = new RomanNumeralsDigitToNumerals();
        //arrange
        int digit = 88;
        String actual = romanObj.convertDigitToRomanNumeral(digit);
        //assert
        assertEquals("LXXXVIII",actual);
    }

    @Test
    public void convert226ToCCXXVI(){
        //act
        RomanNumeralsDigitToNumerals romanObj = new RomanNumeralsDigitToNumerals();
        //arrange
        int digit = 226;
        String actual = romanObj.convertDigitToRomanNumeral(digit);
        //assert
        assertEquals("CCXXVI",actual);
    }

}