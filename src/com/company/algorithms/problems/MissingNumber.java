package com.company.algorithms.problems;

public class MissingNumber {
    public static int findMissing(int[] arr) {

        int sum = 0;
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                index = i;
            } else {
                sum += arr[i];
            }
        }

        int total = (arr.length + 1) * arr.length / 2;

        return total - sum;
    }
}
