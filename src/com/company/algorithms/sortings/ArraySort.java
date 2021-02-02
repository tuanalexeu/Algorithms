package com.company.algorithms.sortings;

import static com.company.algorithms.sortings.ArraySortingTools.countElements;

public class ArraySort {

    ArraySortingTools ast = new ArraySortingTools();

    /** Bubble Sort **/
    public void  bubbleSort(int... N) {
        for (int i = 0; i < N.length-1 ; i++) {
            for (int j = 0; j <N.length-i-1 ; j++) {
                if(N[j]>N[j+1]) {
                    int c = N[j];
                    N[j] = N[j+1];
                    N[j+1] = c;
                }
            }
        }
        ast.printArray("Bubble Sort", N);
    }
    /** Cocktail Sort **/
    public void cocktailSort(int... N) {
        boolean isSwapped = true;
        int start = 0;
        int end = N.length - 1;
        while(isSwapped) {
            for (int i = 0; i < N.length - 1; i++) {
                if(N[i]>N[i+1]) {
                    int c = N[i];
                    N[i] = N[i+1];
                    N[i+1] = c;
                    isSwapped = true;
                }
            }
            end--;
            if (!isSwapped) break;
            isSwapped = false;
            for (int i = end-1; i > start-1; i--) {
                if(N[i]>N[i+1]) {
                    int c = N[i];
                    N[i] = N[i+1];
                    N[i+1] = c;
                    isSwapped = true;
                }
            }
            start++;
        }
        ast.printArray("Cocktail Sort", N);
    }
    /** Comb Sort **/
    public void combSort(int... N) {
        int gap = N.length;
        boolean isSwapped = true;
        while(isSwapped || gap != 1) {
            gap = ast.getNextGap(gap);
            isSwapped = false;
            for (int i = 0; i < N.length - gap ; i++) {
                if(N[i]>N[i+gap]) {
                    int c = N[i];
                    N[i] = N[i+1];
                    N[i+1] = c;
                    isSwapped = true;
                }
            }
        }
        ast.printArray("Comb Sort ", N);
    }
    /** Odd-Even Sort **/
    public void oddEvenSort(int... N) {
        boolean isSwapped = true;
        while(isSwapped) {
            isSwapped = false;
            for (int i = 0; i < N.length-1; i+=2) {
                if(N[i]>N[i+1]) {
                    int c = N[i];
                    N[i] = N[i+1];
                    N[i+1] = c;
                    isSwapped = true;
                }
            }
            for (int i = 1; i < N.length-1; i+=2) {
                if(N[i]>N[i+1]) {
                    int c = N[i];
                    N[i] = N[i+1];
                    N[i+1] = c;
                    isSwapped = true;
                }
            }
        }
        ast.printArray("Odd-Even Sort ", N);
    }

    /**
     * Insertion sorting
     * Сложность O(n^2) или n(n-1)/2
     * Эффективно работает для небольшых массивов
     * или массивов, которые уже частично отсортированы
     * @param N
     */
    public void insertSort(int... N) {
        for (int j = 1; j < N.length; j++) {
            int key = N[j];

            int i = j - 1;
            while (i >= 0 && N[i] > key) {
                N[i+1] = N[i];
                i--;
            }
            N[i+1] = key;
        }
        ast.printArray("Insertion sort", N);
    }


    /** Shell Sort **/
    public void shellSort(int... N) {
        for (int i = N.length/2; i >= 1 ; i/=2) {
            for (int j = 0; j <i ; j++) {
                for (int k = j; k < N.length - 1; k+=i) {
                    for (int l = Math.min(k+i, N.length-1); l-i >=0 ; l-=i) {
                        if(N[l-i]>N[l]) {
                            int tmp = N[l];
                            N[l] = N[l-1];
                            N[l-1] = tmp;
                        }
                        else break;
                    }
                }
            }
        }
        ast.printArray("Shell Sort ", N);
    }

    /** Tree Sort **/
    public void treeSort(int... N) {

    }

    /** Quick Sort **/
    public void quickSort(int[] N, int from, int to) {

        if(from < to) {
            int divideIndex = ast.partition(N, from, to);
            quickSort(N, from, divideIndex - 1);
            quickSort(N, divideIndex, to);
        }
    }

    /** Bingo Sort, particular kind of Selection Sort  **/
    public void BingoSort(int... N) {

    }

    /** Merge Sort **/
    public void mergeSort(int[] array) {
        int[] tmp;
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];
        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                ArraySortingTools.merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }
            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;
            size = size * 2;
        }
        ast.printArray("Merge Sort ", currentSrc);
    }

    /** Selection Sort **/
    public void selectionSort(int[] N) {
        for (int i = 0; i < N.length-1; i++) {
            int max = -999999;
            int index = i;
            for (int j = i+1; j <N.length ; j++) {
                if (N[j] < N[index]) {
                    index = j;
                }
            }
            int z = N[index];
            N[index] = N[i];
            N[i] = z;
        }
        ast.printArray("Selection Sort ", N);
    }

    /** Counting sort **/
    public static int[] countingSort(int[] A) {
        int k = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] > k) {
                k = A[i];
            }
        }
        int[] c = countElements(A, k);

        int[] sorted = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            int current = A[i];
            sorted[c[current] - 1] = current;
            c[current] -= 1;
        }

        return sorted;
    }

}
