package com.alekseytyan.hackerranks.math;

class Handshake {
    /**
     * Complete the 'handshake' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */
    public static int handshake(int n) {
        int sum = 0;
        for (int i = n - 1; i >= 1 ; i--) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(handshake(4));
    }

}