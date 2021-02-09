package com.company.algorithms.problems.arrays;

import java.util.Arrays;

public class MergeSort {
    public static void sort(int[] arr, int start, int end) {
        if(start < end) {
            int middle = (end + start) / 2;
            sort(arr, start, middle);
            sort(arr, middle + 1, end);
            merge(arr, start, middle, end);
        }
    }

    private static void merge(int[] arr, int start, int middle, int end) {
        int n1 = middle - start + 1;
        int n2 = end - middle;

        int[] arr1 = new int[n1 + 1];
        int[] arr2 = new int[n2 + 1];

        System.arraycopy(arr, start, arr1, 0, n1);
        System.arraycopy(arr, middle + 1, arr2, 0, n2);

        arr1[arr1.length - 1] = Integer.MAX_VALUE;
        arr2[arr2.length - 1] = Integer.MAX_VALUE;

        int i = 0, j = 0;

        for (int k = start; k <= end; k++) {
            if(arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,7,4,2,6,67,2,10};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
