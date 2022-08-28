package com.alekseytyan.algorithms.sortings;

import static com.alekseytyan.algorithms.sortings.ArraySortingTools.countElements;

public class ArraySort {

    ArraySortingTools ast = new ArraySortingTools();

    /** Bubble Sort **/
    public void  bubbleSort(int... N) {
        for (int i = 0; i < N.length; i++) {
            for (int j = N.length - 1; j > i; j--) {
                if(N[j] < N[j-1]) {
                    N[j] = (N[j] + N[j-1]) - (N[j-1] = N[j]);
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
     * @param N - Входной набор
     */
    public void insertSort(int[] N) {
        for (int i = 1; i < N.length; i++) {
            int key = N[i];

            int j = i-1;

            while (j>=0 && N[j] > key) {
                N[j+1] = N[j];
                j--;
            }

            N[j+1] = key;
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


    /**
     * Сортировка слиянием, работает по принципу "Разделяй и властвуй"
     * Хорошо подходит для больших массивов, не имеет значения насколько они отсортированны.
     * Требует доп. памяти для хранения промежуточных данных
     * O(ln(n)*n)
     * @param A
     * @param p
     * @param r
     */
    public void simpleMergeSort(int[] A, int p, int r) {
        if(p < r) {
            int q = (p + r) / 2;
            simpleMergeSort(A, p, q);
            simpleMergeSort(A, q+1, r);
            ArraySortingTools.merge(A, p, q, r);
        }
    }

    /** Selection Sort **/
    public void selectionSort(int[] N) {
        for (int i = 0; i < N.length-1; i++) {
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
        for (int j : A) {
            if (j > k) {
                k = j;
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
