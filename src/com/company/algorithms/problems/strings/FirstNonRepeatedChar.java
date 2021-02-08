package com.company.algorithms.problems.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedChar {
    public static char getFirstNonRepeatedChar(String str) {
        Map<Character, Integer> count = new LinkedHashMap<>(str.length());

        for (char c: str.toCharArray()) {
            count.put(c, count.containsKey(c) ? count.get(c) + 1 : 1);
        }

        for (Map.Entry<Character, Integer> entry: count.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("Something went wrong!");
    }
}
