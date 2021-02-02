package com.company.datastructures;

import com.company.algorithms.sortings.MyQuickSort;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] N = new int[10];
        for (int i = 0; i < N.length; i++) {
            N[i] = rand.nextInt(20);
        }
        System.out.println(Arrays.toString(N));
        MyQuickSort.quickSort(N,0,N.length-1);
        System.out.println(Arrays.toString(N));

    }
}
