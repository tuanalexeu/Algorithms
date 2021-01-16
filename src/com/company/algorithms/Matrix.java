package com.company.algorithms;

import java.util.Random;

public class Matrix {
    public static int[][] matrixMultiply(int[][] A, int[][] B) {
        int[][] C;
        if(A[0].length == B.length) {
            C = new int[A.length][B[0].length];
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < C[0].length; j++) {
                    C[i][j] = 0;
                    for (int k = 0; k < B.length ; k++) {
                        C[i][j]+= A[i][k] * B[k][j];
                    }
                }
            }
            return C;
        }
        return null;
    }

    public static void printMatrix(int[][] A) {
        try {
            for(int i = 0; i < A.length ; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    System.out.print(A[i][j] + " ");
                }
                System.out.println();
            }
        } catch (NullPointerException e) {
            System.err.println("Null array");
        }
    }
    public static int[][] fillMatrix(int[][] A) {
        Random rand = new Random();
        for(int i = 0; i < A.length ; i++) {
            for (int j = 0; j < A[0].length; j++) {
                A[i][j]  = rand.nextInt(10);
            }
        }
        return A;
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        if(n == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } else {
            int[][] A11 = divideMatrix(A,1);
            int[][] A12 = divideMatrix(A,2);
            int[][] A21 = divideMatrix(A,3);
            int[][] A22 = divideMatrix(A,4);

            int[][] B11 = divideMatrix(B,1);
            int[][] B12 = divideMatrix(B,2);
            int[][] B21 = divideMatrix(B,3);
            int[][] B22 = divideMatrix(B,4);

            int [][] M1 = multiply(add(A11, A22), add(B11, B22));
            int [][] M2 = multiply(add(A21, A22), B11);
            int [][] M3 = multiply(A11, sub(B12, B22));
            int [][] M4 = multiply(A22, sub(B21, B11));
            int [][] M5 = multiply(add(A11, A12), B22);
            int [][] M6 = multiply(sub(A21, A11), add(B11, B12));
            int [][] M7 = multiply(sub(A12, A22), add(B21, B22));

            int [][] C11 = add(sub(add(M1, M4), M5), M7);
            int [][] C12 = add(M3, M5);
            int [][] C21 = add(M2, M4);
            int [][] C22 = add(sub(add(M1, M3), M2), M6);

            C = join(C11, C12, C21, C22);
        }
        return C;
    }

    public static int[][] divideMatrix(int[][] A, int fourth) {
        int n = A.length / 2;
        int[][] R = new int[n][n];
        switch (fourth) {
            case 1:
                for (int i = 0; i < n ; i++) {
                    for (int j = 0; j < n ; j++) {
                        R[i][j] = A[i][j];
                    }
                }
                break;
            case 2:
                for (int i = 0; i < n ; i++) {
                    for (int j = 0; j < n ; j++) {
                        R[i][j] = A[i][j + n];
                    }
                }
                break;
            case 3:
                for (int i = 0; i < n ; i++) {
                    for (int j = 0; j < n ; j++) {
                        R[i][j] = A[i + n][j];
                    }
                }
                break;
            case 4:
                for (int i = 0; i < n ; i++) {
                    for (int j = 0; j < n ; j++) {
                        R[i][j] = A[i + n][j + n];
                    }
                }
                break;
        }
        return R;
    }

    public static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static int[][] sub(int [][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    public static int[][] join(int[][] A, int[][] B, int[][] C, int[][] D) {
        int n = A.length * 2;
        int[][] R = new int[n][n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                if(i < A.length) {
                    if(j < B.length) {
                        R[i][j] = A[i][j];
                    } else {
                        R[i][j] = B[i][j-n/2];
                    }
                } else {
                    if(j < C.length) {
                        R[i][j] = C[i-n/2][j];
                    } else {
                        R[i][j] = D[i-n/2][j-n/2];
                    }
                }
            }
        }
        return R;
    }

}
