package com.alekseytyan.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an integer array nums, return the largest perimeter of a triangle with a non-zero area,
 * formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.
 *
 * Example 1:
 * Input: nums = [2,1,2]
 * Output: 5
 *
 * Example 2:
 * Input: nums = [1,2,1]
 * Output: 0
 */
public class LargestPerimeterTriangle {
    public static int largestPerimeter(int[] nums) {
        PriorityQueue<Integer> prq = new PriorityQueue<>(Collections.reverseOrder());
        prq.addAll(convertToCollection(nums));

        // nums.length >= 3
        int a = prq.poll(), b = prq.poll(), c = prq.poll();
        if(a < b + c) {
            return a + b + c;
        }

        while (!prq.isEmpty()) {
            a = b;
            b = c;
            c = prq.poll();

            if(a < b + c) {
                return a + b + c;
            }
        }

        return 0;
    }

    private static Collection<Integer> convertToCollection(int[] nums) {
        Collection<Integer> result = new ArrayList<>(nums.length);
        for (Integer element: nums) {
            result.add(element);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[] {3,6,2,3};
        int output = largestPerimeter(input);
        System.out.println(output);
    }
}