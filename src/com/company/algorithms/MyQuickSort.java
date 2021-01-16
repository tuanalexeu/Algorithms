package com.company.algorithms;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Randomized Quick Sort
 */
public class MyQuickSort {
    public static void quickSort(int[] A, int start, int finish) {
        if(start < finish) {
            int q = partition(A,start,finish);
            quickSort(A,start,q-1);
            quickSort(A,q+1,finish);
        }

    }
    private static int partition(int[] A, int start, int finish) {
        // To make it randomized
        int i = ThreadLocalRandom.current().nextInt(start, finish+1);
        int v = A[finish];
        A[finish] = A[i];
        A[i] = v;
        // To make it randomized

        int l = start - 1;
        int x = A[finish];
        for (int j = start; j < finish; j++) {
            if(A[j] <= x) {
                l++;
                int d = A[j];
                A[j] = A[l];
                A[l] = d;
            }
        }
        int d = A[l+1];
        A[l+1] = A[finish];
        A[finish] = d;
        return l+1;
    }
}
