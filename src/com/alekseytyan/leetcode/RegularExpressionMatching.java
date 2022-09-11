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

    @SuppressWarnings("all")
    public static boolean isMatch(String string, String pattern) {
        int pid = 0;
        for (int i = 0; i < string.length(); i++) {
            char s = string.charAt(i);
            char p = pattern.charAt(pid);

            if(s == p || p == '.') {
                continue;
            }

            if(p == '*') {
                // It is garantueed that we have a valid characted before any '*'
                // Thus, no IndexOutOfBoundsException will be thrown
                char previous = pattern.charAt(pid - 1);
                if(s == previous || previous == '.') {
                    continue;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String text = "aa";
        String regex = "a*";

        boolean output = isMatchUsingPattern(text, regex);
        System.out.println(output);
    }
}


/**
 * afadfsdfavac
 *
 * a.*
 */
