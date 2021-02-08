package com.company.algorithms.problems.arrays;

public class FindDuplicate {
    public static int findDuplicate(int[] arr) {

        int dupe = 0;

        for (int i = 0; i < arr.length; i++) {
            dupe = dupe ^ arr[i-1] ^ i;
        }

        return dupe;
    }
}
