package com.company.algorithms.sortings;

import java.util.Arrays;

public class ArraySortingTools {
    public void printArray(String name, int... N) {
        for (int i= 0; i < N.length; i++) {
            System.out.print(N[i] + " ");
        }
        System.out.println(" " + name);
    }
    public int getNextGap(int gap) {
        gap = (gap*10)/13;
        if (gap < 1)
            return 1;
        return gap;
    }

    public int partition(int[] N, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        int pivot = N[from + (to - from)/2];

        while(leftIndex <= rightIndex) {

            while(N[leftIndex] < pivot) leftIndex++;

            while(N[rightIndex] > pivot) rightIndex--;

            if(leftIndex <= rightIndex) {
                swap(N, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private void swap(int[] array, int index1, int index2) {
        int tmp  = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest,
                             int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    public static int[] countElements(int[] A, int k) {
        int[] c = new int[k + 1];
        Arrays.fill(c, 0);

        for (int i : A) {
            c[i] += 1;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        return c;
    }
}