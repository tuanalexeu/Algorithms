package com.alekseytyan.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionMatching {
    public static boolean isMatchUsingPattern(String s, String p) {
        Pattern pattern = Pattern.compile(p);

        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            if(s.substring(matcher.start(), matcher.end()).equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMatch(String s, String p) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        String text = "aa";
        String regex = "a*";

        boolean output = isMatchUsingPattern(text, regex);
        System.out.println(output);
    }
}
