package com.company;

import com.company.algorithms.ArraySort;

public class Main {

    public static void main(String[] args) {

	    int[] a = new int[] {16,5,7,3,7,5,2,6,10,0,4,1};
        int[] b = a.clone();

        ArraySort arraySort = new ArraySort();
        arraySort.bubbleSort(a.clone());
        arraySort.cocktailSort(a.clone());
        arraySort.combSort(a.clone());
        arraySort.oddEvenSort(a.clone());
        arraySort.insertSort(a.clone());
        arraySort.shellSort(a.clone());
        arraySort.selectionSort(a.clone());
        arraySort.quickSort(b, 0, b.length - 1);
        for (int i = 0; i <b.length ; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println(" Quick Sort");

        arraySort.mergeSort(a.clone());


    }
}
