package com.alekseytyan.leetcode;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * Constraints:
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = mergeSorted(nums1, nums2);
        int len = arr.length;

        if (len == 1) {
            return arr[0];
        } else if (len % 2 != 0) {
            return arr[len / 2];
        } else {
            return (double) (arr[len / 2 - 1] + arr[len / 2]) / 2;
        }
    }

    private static int[] mergeSorted(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int n = 0, m = 0;
        for (int i = 0; i < result.length; i++) {
            if(n < nums1.length && (m >= nums2.length || nums1[n] <= nums2[m])) {
                result[i] = nums1[n];
                n++;
            } else {
                result[i] = nums2[m];
                m++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] inputParam1 = new int[] {1, 2};
        int[] inputParam2 = new int[] {3, 4};

        double output = findMedianSortedArrays(inputParam1, inputParam2);
        System.out.println(output);
    }
}