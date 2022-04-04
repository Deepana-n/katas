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

}
