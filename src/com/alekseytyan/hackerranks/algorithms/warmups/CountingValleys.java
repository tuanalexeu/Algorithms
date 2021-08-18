package com.alekseytyan.hackerranks.algorithms.warmups;

public class CountingValleys {
    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {

        int level = 0;
        int result = 0;

        for (int i = 0; i < path.length(); i++) {
            if(path.charAt(i) == 'U') {
                level++;
                if(level == 0) {
                    result++;
                }
            } else if(path.charAt(i) == 'D') {
                level--;
            }
        }

        return result;
    }
}
