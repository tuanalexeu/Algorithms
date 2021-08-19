package com.alekseytyan.hackerranks.ds.hashtables;

import java.util.HashMap;
import java.util.Map;

public class TwoStrings {
    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String s1, String s2) {

        Map<Character, Boolean> dict = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            dict.put(s1.charAt(i), false);
        }

        for (int i = 0; i < s2.length(); i++) {
            if(dict.containsKey(s2.charAt(i))) {
                return "YES";
            }
        }

        return "NO";
    }
}
