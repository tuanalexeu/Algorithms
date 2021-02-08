package com.company.algorithms.problems.strings;

public class ReverseString {

    public static String reverseIterative(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] strChars = s.toCharArray();

        for (int i = strChars.length - 1; i >= 0 ; i--) {
            stringBuilder.append(strChars[i]);
        }

        return stringBuilder.toString();
    }

    public static String reverseRecursive(String s) {
        if(s.length() < 2) {
            return s;
        }
        return reverseRecursive(s.substring(1)) + s.charAt(0);
    }

    public static boolean isPalindrome(String s) {
        String reverse = reverseRecursive(s);

        return reverse.equals(s);
    }

}
