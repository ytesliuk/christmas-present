package controller.util;

import java.util.regex.*;

/**
 * Created by Yuliia Tesliuk on 11/06/2018
 */
public class Util {
    public static boolean isWithinBounds(int value, int min, int max){
        return value >= min && value <= max;
    }

    public static boolean isWithinBounds(double value, double min, double max){
        return Double.compare(value,min) >= 0 && Double.compare(value,max) <= 0 ;
    }

    public static int stringToInt(String str, int defaultValue){
        if(str == null) return defaultValue;
        Pattern p = Pattern.compile("([0])|([1-9]+[0-9]*)");
        Matcher m = p.matcher(str);
        return m.matches() ? Integer.valueOf(str) : defaultValue;
    }

    public static double stringToDouble(String str, double defaultValue){
        if(str == null) return defaultValue;
        Pattern p = Pattern.compile("([0])|" +
                "([0][.][0-9]+)|" +
                "([1-9]+[0-9]*)|" +
                "([1-9]+[0-9]*[.][0-9]+)");
        Matcher m = p.matcher(str);
        return m.matches() ? Double.valueOf(str) : defaultValue;
    }
}
