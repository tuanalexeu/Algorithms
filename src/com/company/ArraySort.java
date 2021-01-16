package com.company;


import java.awt.image.renderable.RenderableImage;

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
    /** Insert Sort **/
    public void insertSort(int... N) {
        for (int i = 0; i <N.length ; i++) {
            for (int j = i; j > 0 ; j--) {
                if(N[j-1]>N[j]) {
                    int c = N[j];
                    N[j] = N[j-1];
                    N[j-1] = c;
                }
            }
        }
        ast.printArray("Insert Sort ", N);
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
            int divideIndex = ast.parition(N, from, to);
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

}

class ArraySortingTools {
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

    public int parition(int[] N, int from, int to) {
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
}
