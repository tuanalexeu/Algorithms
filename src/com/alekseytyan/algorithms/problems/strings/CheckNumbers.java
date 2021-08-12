package com.alekseytyan.algorithms.problems.strings;

public class CheckNumbers {
    public static boolean checkNumbers(String s) {
        for (Character c: s.toCharArray()) {
            if(!isNumeric(c)) return false;
        }
        return true;
    }

    private static boolean isNumeric(char s) {
        try {
            Double.parseDouble(String.valueOf(s));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
