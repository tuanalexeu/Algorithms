package com.alekseytyan.hackerranks.algorithms.warmups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JumpingOnTheClouds {
    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {

        int current = 0;
        int jumps = 0;

        for (int i = 0; i < c.size(); i++) {

            if(i != current) {
                continue;
            }

            jumps++;

            current = i < c.size() - 2 && c.get(i + 2) == 0
                    ? current + 2
                    : current + 1;
        }

        return --jumps;
    }


    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(new ArrayList<>(Arrays.asList(0,0,0,1,0,0))));
    }
}
