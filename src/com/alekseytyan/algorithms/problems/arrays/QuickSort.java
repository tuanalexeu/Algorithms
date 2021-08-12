package com.alekseytyan.algorithms.problems.arrays;

import java.util.Arrays;

public class QuickSort {

    public static int[] sort(int[] arr, int start, int end) {
        if(start < end) {
            int q = partition(arr, start, end);
            sort(arr, start, q - 1);
            sort(arr, q + 1, end);
        }
        return arr;
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if(arr[j] <= pivot) {
                i++;
                arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
            }
        }

        arr[i+1] = (arr[i+1] + arr[end]) - (arr[end] = arr[i+1]);
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,3,2,7,4,5,6,2,10};
        System.out.println(Arrays.toString(sort(arr, 0, arr.length - 1)));
    }
}
