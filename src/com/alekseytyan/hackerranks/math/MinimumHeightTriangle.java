package com.alekseytyan.hackerranks.math;

public class MinimumHeightTriangle {
    /**
     * Complete the 'lowestTriangle' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER trianglebase
     *  2. INTEGER area
     */
    public static int lowestTriangle(int trianglebase, int area) {
        return (int) Math.ceil(((area * 2.0) / trianglebase));
    }

    public static void main(String[] args) {
        System.out.println(lowestTriangle(17, 100));
    }

}
