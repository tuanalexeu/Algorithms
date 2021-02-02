package com.company.algorithms.sortings;


public class Main {

    public static void main(String[] args) {

	    int[] a = new int[] {16,5,7,3,7,5,2,6,10,0,4,1};

        ArraySort arraySort = new ArraySort();
        arraySort.bubbleSort(a.clone());
        arraySort.cocktailSort(a.clone());
        arraySort.combSort(a.clone());
        arraySort.oddEvenSort(a.clone());
        arraySort.insertSort(a.clone());
        arraySort.shellSort(a.clone());
        arraySort.selectionSort(a.clone());
        arraySort.mergeSort(a.clone()); // Итеративный подход

        // В следующих двух сортировках (QuickSort & MergeSort) применяется
        // парадигма "разделяй и властвуй", что подразумевает рекурсивный вызов.
        // Поэтому мы не можем вывести массив в самом методе и выводим его здесь
        int[] quickSortArray = a.clone();
        arraySort.quickSort(quickSortArray, 0, quickSortArray.length - 1);
        for (int j : quickSortArray) {
            System.out.print(j + " ");
        }
        System.out.println(" Quick Sort");

        int[] simpleMergeArray = a.clone();
        arraySort.simpleMergeSort(simpleMergeArray, 0, simpleMergeArray.length - 1);
        for (int j: simpleMergeArray) {
            System.out.print(j + " ");
        }
        System.out.println(" Simple Merge Sort");


    }
}
