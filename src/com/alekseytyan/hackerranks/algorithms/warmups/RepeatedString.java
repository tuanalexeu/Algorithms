package com.alekseytyan.hackerranks.algorithms.warmups;

public class RepeatedString {
    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {

        long occurrences = 0;
        long partial = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') {
                if(i < n % s.length()) { // TODO find out what to put instead of 'n % s.length()' expression
                    partial++;
                }
                occurrences++;
            }
        }

        return occurrences * n / s.length() + partial;
    }

    public static void main(String[] args) {
        System.out.println(repeatedString("aba", 10)); // aba aba aba aba

        // s.length > n
        // s.length < n
        // s.length == n

    }
}
