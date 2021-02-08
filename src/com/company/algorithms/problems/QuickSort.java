package com.company.algorithms.problems;

import java.util.Arrays;

public class QuickSort {
    public static int[] sort(int[] arr, int p, int r) {
        if(p < r) {
            int q = partition(arr, p ,r);
            sort(arr,p,q-1);
            sort(arr,q+1, r);
        }
        return arr;
    }

    public static int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;

        for (int j = p; j < r; j++) {
            if(arr[j] <= x) {
                i++;
                arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
            }
        }
        arr[i+1] = (arr[i+1] + arr[r]) - (arr[r] = arr[i+1]);
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,3,2,7,4,5,6,2,10};
        System.out.println(Arrays.toString(sort(arr, 0, arr.length - 1)));
    }
}
