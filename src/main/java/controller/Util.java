package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yuliia Tesliuk on 11/06/2018
 */
public class Util {
    public static boolean isWithinBounds(int value, int min, int max){
        return value >= min && value <= max;
    }

    public static int toInteger(String str, int defaultValue){
        if(str == null) return defaultValue;
        Pattern p = Pattern.compile("([0])|([1-9]+[0-9]*)");
        Matcher m = p.matcher(str);
        return m.matches() ? Integer.valueOf(str) : defaultValue;
    }
}
