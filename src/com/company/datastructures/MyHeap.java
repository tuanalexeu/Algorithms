package com.company.datastructures;

import java.util.ArrayList;

public class MyHeap {
    public static int heapSize;
    public static void maxHeapFix(ArrayList<Integer> A, int index) {
        int left = left(index);
        int right = right(index);
        int largest = Integer.MIN_VALUE;
        if(left <= heapSize && A.get(left) > A.get(index)) {
            largest = left;
        } else {
            largest = index;
        }
        if(right <= heapSize && A.get(right) > A.get(largest)) {
            largest = right;
        }
        if(largest != index) {
            int v = A.get(index);
            A.set(index,A.get(largest));
            A.set(largest, v);
            maxHeapFix(A,largest);
        }
    }
    public static void buildMaxHeap(ArrayList<Integer> A) {
        heapSize = A.size() - 1;
        for (int i = (A.size()-1) / 2; i >= 0; i--) {
            maxHeapFix(A, i);
        }
    }

    public static void heapSort(ArrayList<Integer> A) {
        buildMaxHeap(A);
        for (int i = A.size() - 1; i >= 1; i--) {
            int v = A.get(i);
            A.set(i, A.get(0));
            A.set(0, v);
            heapSize--;
            maxHeapFix(A,0);
        }
    }

    public static int parent(int index) {
        return index / 2 - 1;
    }
    public static int left(int index) {
        return index * 2 + 1;
    }
    public static int right(int index) {
        return index * 2 + 2;
    }

}
