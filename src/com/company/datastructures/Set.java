package com.company.datastructures;

import com.company.datastructures.TwoTuple;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Set {
    public static void grayCode(int n) {
        ArrayList<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");

        for (int i = 2; i < (1<<n); i <<= 1) {
            for (int j = i-1; j >= 0 ; j--) {
                list.add(list.get(j));
            }
            for (int j = 0; j < i; j++) {
                list.set(j,"0" + list.get(j));
            }

            for (int j = i; j < i * 2; j++) {
                list.set(j,"1" + list.get(j));
            }
        }
        printList(list);
    }

    private static void printList(List<?> list) {
        for (Object l:list) {
            System.out.println(l.toString());
        }
    }

    public static TwoTuple<Integer, Integer> getMinMax(int[] A) {
        int max, min;
        if(A.length % 2 != 0) {
            max = A[0];
            min = A[0];
            for (int i = 1; i < A.length-1; i+=2) {
               var minMax = findMinMax(A,i,max,min);
               max = minMax.getMax();
               min = minMax.getMin();
            }
        } else {
            max = max(A[0],A[1]);
            min = min(A[0],A[1]);
            for (int i = 2; i < A.length-1; i+=2) {
                var minMax = findMinMax(A,i,max,min);
                max = minMax.getMax();
                min = minMax.getMin();
            }
        }
        return new TwoTuple<>(max,min);
    }

    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    public static TwoTuple<Integer,Integer> findMinMax(int[] A, int i, int max, int min) {
        if(A[i] > A[i+1]) {
            if(A[i] > max) max = A[i];
            if(A[i+1] < min) min = A[i+1];
        } else {
            if(A[i] < min) min = A[i];
            if(A[i+1] > max) max = A[i+1];
        }
        return new TwoTuple<>(max,min);
    }

    public static int randomizedSelect(int[] A, int start, int finish, int i) {
        if(start == finish) return A[start];
        int q = partition(A,start,finish);
        int k = q - start + 1;
        if(i == k) return A[q];
        else if(i<k) {
            return randomizedSelect(A,start,q-1,i);
        } else {
            return randomizedSelect(A,q+1,finish,i-k);
        }
    }
    private static int partition(int[] A, int start, int finish) {
        // ================To make it randomized================
        int i = ThreadLocalRandom.current().nextInt(start, finish+1);
        int v = A[finish];
        A[finish] = A[i];
        A[i] = v;
        // =====================================================

        int l = start - 1;
        int x = A[finish];
        for (int j = start; j < finish; j++) {
            if(A[j] <= x) {
                l++;
                int d = A[j];
                A[j] = A[l];
                A[l] = d;
            }
        }
        int d = A[l+1];
        A[l+1] = A[finish];
        A[finish] = d;
        return l+1;
    }
}