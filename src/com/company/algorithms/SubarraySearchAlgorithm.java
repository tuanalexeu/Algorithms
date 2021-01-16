package com.company.algorithms;


public class SubarraySearchAlgorithm {
    public ThreeTuple<Integer, Integer, Integer> findMaxCrossingSubarray(int[] N, int low, int mid, int high) {

        int leftSum = -999999999, rightSum = -999999999;
        int sum = 0;
        int maxLeft = -1, maxRight = -1;

        for (int i = mid; i >= low; i--) {
            sum += N[i];
            if(sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        sum = 0;

        for (int i = mid + 1; i <= high ; i++) {
            sum += N[i];
            if(sum>rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }
        return new ThreeTuple<>(maxLeft, maxRight, leftSum + rightSum);
    }

    public ThreeTuple<Integer, Integer, Integer> findMaxSubarray(int[] N, int low, int high) {
        if(high == low) return new ThreeTuple<>(low, high, N[low]);
        else {
            int mid = (low + high) / 2;

            ThreeTuple<Integer, Integer, Integer> maxLeftSubArr =
                    findMaxSubarray(N,low, mid);

            ThreeTuple<Integer, Integer, Integer> maxRightSubArr =
                    findMaxSubarray(N, mid + 1, high);

            ThreeTuple<Integer, Integer, Integer> maxCrossSubArr =
                    findMaxCrossingSubarray(N, low, mid, high);

            if(maxLeftSubArr.sum >= maxRightSubArr.sum &&
                    maxLeftSubArr.sum >= maxCrossSubArr.sum) {
                return new ThreeTuple<>(maxLeftSubArr.low, maxLeftSubArr.high, maxLeftSubArr.sum);
            } else if(maxRightSubArr.sum >= maxLeftSubArr.sum &&
                    maxRightSubArr.sum >= maxCrossSubArr.sum) {
                return new ThreeTuple<>(maxRightSubArr.low, maxRightSubArr.high, maxRightSubArr.sum);
            } else {
                return new ThreeTuple<>(maxCrossSubArr.low, maxCrossSubArr.high, maxCrossSubArr.sum);
            }
        }
    }

    public int maxSub(int[] N) {
        int maxCurrent = N[0];
        int maxGlobal = N[0];
        for (int i = 1; i <N.length; i++) {
            maxCurrent = max(N[i], N[i] + maxCurrent);
            if(maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }
        return maxGlobal;
    }

    public static int max(int a, int b) {
        return a >= b ? a : b;
    }
}
