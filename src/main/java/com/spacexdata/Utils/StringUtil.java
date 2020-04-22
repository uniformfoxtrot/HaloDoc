package com.spacexdata.Utils;

public class StringUtil {
    public static String stringReplace(String s) {
        String replacedString = s.replace("[","");
        String finalReplacedString = replacedString.replace("]","");
        return finalReplacedString;
    }
}
