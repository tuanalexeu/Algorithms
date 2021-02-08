package com.company.algorithms.problems;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void removeDuplicates(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    arr[j] = 0;
                }
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == 0) {
                int j = i+1;
                while (j < arr.length-1 && arr[j] == 0) {
                    j++;
                }
                for (int k = j; k > i; k--) {
                    arr[k] = (arr[k] + arr[k-1]) - (arr[k-1] = arr[k]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,5,6,4,2,6,7,111,50};
        removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
    }
}
