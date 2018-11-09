package com.present.controller.util;

import com.present.controller.util.NumberUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Yuliia Tesliuk on 11/06/2018
 */
class NumberUtilTest {

    @Test
    void stringToInt() {
        String[] invalidStrings = {null, "", "asd", "45df", "0425"};
        String[] validStrings  = {"4", "15", "150", "1500", "0"};

        for(String str : invalidStrings){
            int result = NumberUtil.stringToInt(str,20);
            assertEquals(20,result, str);
        }
        for(String str : validStrings){
            int result = NumberUtil.stringToInt(str,20);
            assertEquals(Integer.parseInt(str),result, str);
        }
    }

    @Test
    void stringToDouble() {
        String[] invalidStrings = {null, "", "asd", "45df", "042.5", "0.455f"};
        String[] validStrings  = {"0", "15", "15.0", "0.05", "0.50", "0.50"};

        for(String str : invalidStrings){
            double result = NumberUtil.stringToDouble(str,20.0);
            assertEquals(20.0,result, str);
        }
        for(String str : validStrings){
            double result = NumberUtil.stringToDouble(str,20);
            assertEquals(Double.parseDouble(str),result, str);
        }
    }

    @Test
    void isWithinBoundsDouble() {
        assertTrue(NumberUtil.isWithinBounds(5.0,2,6));
        assertTrue(NumberUtil.isWithinBounds(5.0,5.0,6));
        assertTrue(NumberUtil.isWithinBounds(5.0,2,5.0));
        assertTrue(NumberUtil.isWithinBounds(5.0,5.00,6));
        assertFalse(NumberUtil.isWithinBounds(4.99,5.0,6));
        assertFalse(NumberUtil.isWithinBounds(4.99,3,4.98999),"value = 4.99, min = 3, max = 4.99998");
    }

    @Test
    void isWithinBoundsInt() {
        assertTrue(NumberUtil.isWithinBounds(5,2,6));
        assertTrue(NumberUtil.isWithinBounds(5,5,6));
        assertTrue(NumberUtil.isWithinBounds(5,2,5));
        assertFalse(NumberUtil.isWithinBounds(4,5,6));
        assertFalse(NumberUtil.isWithinBounds(7,5,6));
    }
}