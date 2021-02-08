package com.company.algorithms.problems;

import java.util.Arrays;

public class ReverseArray {
    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            arr[i] = (arr[i] + arr[arr.length - i - 1]) - (arr[arr.length - i - 1] = arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,7,4,2,5,8,4,10,5};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
}
