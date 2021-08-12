package com.alekseytyan.datastructures;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
    public static void quickSorting(int[] A, int start, int finish) {
        if(start < finish) {
            int q = partition(A,start,finish);
            quickSorting(A,start,q-1);
            quickSorting(A,q+1,finish);
        }
    }

    private static int partition(int[] A, int start, int finish) {
        int x = A[finish];
        int i = start - 1;
        for (int j = start; j < finish; j++) {
            if(A[j] <= x) {
                i++;
                int v = A[i];
                A[i] = A[j];
                A[j] = v;
            }
        }
        int v = A[i+1];
        A[i+1] = A[finish];
        A[finish] = v;
        return i+1;
    }

    private static int randomizedPartition(int[] A, int start, int finish) {
        int i = ThreadLocalRandom.current().nextInt(start,finish+1);
        int v = A[i];
        A[i] = A[finish];
        A[finish] = v;
        return partition(A,start,finish);
    }

    public static void randomizedQuickSort(int[] A, int start, int finish) {
        if(start < finish) {
           int q = randomizedPartition(A,start,finish);
           randomizedQuickSort(A,start, q-1);
           randomizedQuickSort(A, q+1, finish);
        }
    }
}
