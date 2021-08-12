package com.alekseytyan.datastructures;

import java.util.ArrayList;

public class MyPriorityQueue extends MyHeap {
    public static int heapMaximum(ArrayList<Integer> A) {
        return A.get(0);
    }

    public static int heapExtractMax(ArrayList<Integer> A) {
        if(heapSize < 1) {
            try {
                throw new Exception("The queue is empty");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        int max = A.get(0);
        A.set(0, A.get(heapSize));
        heapSize--;
        maxHeapFix(A, 0);
        return max;
    }

    public static void heapIncreaseKey(ArrayList<Integer> A, int index, int key) {
        if(key < A.get(index)) {
            try {
                throw new Exception("Current key is less than former");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        A.set(index, key);
        while(index > 0 && A.get(parent(index)) < A.get(index)) {
            int v = A.get(index);
            A.set(index, A.get(parent(index)));
            A.set(parent(index), v);
            index = parent(index);
        }
    }

    public static void maxHeapInsert(ArrayList<Integer> A, int key) {
        A.set(++heapSize, Integer.MIN_VALUE);
    }
}
