package com.alekseytyan.hackerranks.algorithms.warmups;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesByMatch {
    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {

        Map<Integer, Integer> pairs = new HashMap<>();
        for (Integer e : ar) {
            pairs.put(e, pairs.containsKey(e) ? pairs.get(e) + 1 : 1);
        }

        return pairs.values().stream()
                .mapToInt(integer -> integer / 2)
                .sum();
    }
}
