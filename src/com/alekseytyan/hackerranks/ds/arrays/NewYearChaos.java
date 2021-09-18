package com.alekseytyan.hackerranks.ds.arrays;

import java.util.Arrays;
import java.util.List;

public class NewYearChaos {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */
    public static void minimumBribes(List<Integer> q) {
        int result = 0;

        for (int i = q.size() - 1; i >= 0; i--) {
            if(q.get(i) - i > 3) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                if(q.get(j) > q.get(i)) result++;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        minimumBribes(Arrays.asList(5,1,2,3,7,8,6,4));
        minimumBribes(Arrays.asList(1,2,5,3,7,8,6,4));
    }
}
