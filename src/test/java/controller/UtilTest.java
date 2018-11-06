package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Yuliia Tesliuk on 11/06/2018
 */
class UtilTest {

    @Test
    void isWithinBounds() {
    }

    @Test
    void toInteger() {
        String[] invalidStrings = {null, "", "asd", "45df", "0425"};
        String[] validStrings  = {"0", "15", "150", "1500", "0"};

        for(String str : invalidStrings){
            int result = Util.toInteger(str,20);
            assertEquals(20,result, str);
        }
        for(String str : validStrings){
            int result = Util.toInteger(str,20);
            assertEquals(Integer.parseInt(str),result, str);
        }
    }
}