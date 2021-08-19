package com.alekseytyan.hackerranks.ds.hashtables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RansomNote {
    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Integer> dict = new HashMap<>();

        for (String n: note) {
            dict.put(n, dict.containsKey(n) ? dict.get(n) + 1 : 1);
        }

        for (String m: magazine) {
            if(dict.containsKey(m)) {
                dict.put(m, dict.get(m) - 1);
            }
        }

        boolean result = dict.values().stream().allMatch(v -> v <= 0);

        System.out.println(result ? "Yes" : "No");
    }
}
