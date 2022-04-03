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

}
