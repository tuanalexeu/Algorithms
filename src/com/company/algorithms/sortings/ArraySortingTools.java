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

    /**
     * Метод слияния двух массивов.
     * Служит как вспомогательный инструмент для сортировки слиянием.
     * @param src1 - Первый массив
     * @param src1Start - Индекс начала первого массива
     * @param src2 - Втором массив
     * @param src2Start - Индекс начала второго массива
     * @param dest - Массив, который будет результатом слияния
     * @param destStart - Индекс начала результирующего массива
     * @param size - количество элементов для слияния
     */
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

    /**
     * Метод слияния двух массивов.
     * Служит как вспомогательный инструмент для сортировки слиянием.
     * @param A - Исходный массив
     * @param p - индекс начала первого подмассива
     * @param q - индекс конца первого подмассива
     * @param r - индекс конца второго подмассива
     */
    public static void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1; // Вычисляем размер первого подмассива
        int n2 = r - q; // И второго

        int[] L = new int[n1 + 1]; // Left subarray
        int[] R = new int[n2 + 1]; // Right subarray

        System.arraycopy(A, p, L, 0, n1);
        System.arraycopy(A, q + 1, R, 0, n2);

        L[L.length - 1] = Integer.MAX_VALUE;
        R[R.length - 1] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if(L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
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