package com.company.algorithms;

public class BinarySearch {

    public int binarySearchIterative(int[] N, int start, int finish, int value) {
        if(start <= finish) {
            int mid = start + (finish - start) / 2;

            if(N[mid] == value) {
                return mid;
            } else if(N[mid] > value) {
                return binarySearchIterative(N,start,mid,value);
            } else {
                return binarySearchIterative(N,mid+1, finish, value);
            }
        }
        return -1;
    }

    public int binarySearchRecursive(int[] N, int value) {
        int start = 0, finish = N.length;

        while (start <= finish) {
            int mid = start + (finish - start) / 2;
            if(N[mid] == value) {
                return mid;
            } else if(N[mid] > value) {
                finish = mid + 1;
            } else {
                start = mid - 1;
            }
        }
        return -1;
    }

}
