package com.company;

import java.util.*;

public class RandomizedAlgorithms {

    static Random rand = new Random();

    public static void randomizeArray(int[] N) {
        Map<Integer,Integer> map = new TreeMap<>();
        int n = N.length;
        for (int i = 0; i < n; i++) {
            map.put(rand.nextInt(n*n*n),N[i]);
        }
        int i = 0;
        for (Map.Entry<Integer,Integer> m: map.entrySet()) {
            N[i++] = m.getValue();
        }
    }

    public static void randomizeInPlace(int[] N) {
        int n = N.length;
        for (int i = 0; i < n; i++) {
            int c = N[i];
            int r = rand.nextInt(n - i) + i;
            N[i] = N[r];
            N[r] = c;
        }
    }

    public static int randomSearch(int[] N, int k) {
        int n = N.length;
        int f = N.length;
        Map<Integer,Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i,true);
        }
        while(f>0) {
            int current = rand.nextInt(n);
            if(N[current] == k) {
                return current;
            } else if(map.get(current) == true) {
                map.put(current, false);
                f--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] N = new int[20];
        for (int i = 0; i < N.length; i++) {
            N[i] = rand.nextInt(20);
        }
        randomizeInPlace(N);
        System.out.println(Arrays.toString(N));
        System.out.println(randomSearch(N,11));
    }
}
