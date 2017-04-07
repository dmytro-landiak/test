package com.landim.lab4;

import java.util.Arrays;


public class Matrix {

    private int[][] value;

    public Matrix(int[][] value) {

        if(value == null) {
            throw new IllegalArgumentException("Matrix can not be null");
        }

        if(value.length == 0 || value[0].length == 0) {
            throw new IllegalArgumentException("Matrix can not be empty");
        }

        for(int i = 0; i < value.length; i++) {

            if(value[i] == null || value[i].length != value[0].length) {
                throw new IllegalArgumentException("Matrix is not rectangle");
            }
        }

        this.value = value;
    }

    public Matrix multuply(Matrix matrix) {

        if(matrix == null) {
            throw new IllegalArgumentException("Matrix can not be null");
        }

        if(this.value[0].length != matrix.value.length) {
            throw new IllegalArgumentException("Matrix sizes don't match!");
        }

        int[][] valueResult = matrixMultiply(this.value, matrix.value);

        return new Matrix(valueResult);
    }

    public Matrix sum(Matrix matrix) {

        if(matrix == null) {
            throw new IllegalArgumentException("Matrix can not be null");
        }

        if(this.value.length != matrix.value.length || this.value[0].length != matrix.value[0].length) {
            throw new IllegalArgumentException("Matrix sizes don't match!");
        }

        int[][] valueResult = matrixSum(this.value, matrix.value);
        return new Matrix(valueResult);

    }

    public Matrix multiply(int constant) {

        int[][] valueResult = multiply(this.value, constant);
        return new Matrix(valueResult);
    }

    /**
     * Multiplies matrixes
     * @param A - left matrix
     * @param B - right matrix
     * @return result of multiplying
     */
    private int[][] matrixMultiply(int[][] A, int[][] B) {

        if(A == null || B == null || A.length == 0 || B.length == 0 || A[0].length != B.length)
            throw new IllegalArgumentException("Matrix sizes don't match!");

        int[][] C = new int[A.length][B[0].length];

        for(int i = 0; i < C.length; i++) {

            for(int j = 0; j < C[0].length; j++) {

                int res = 0;
                for(int k = 0; k < A[0]. length; k++)
                    res += A[i][k] * B[k][j];

                C[i][j] = res;
            }
        }

        return C;
    }

    private int[][] matrixSum(int[][] a, int[][] b) {

        int[][] c = new int[a.length][a[0].length];
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        return c;
    }

    private int[][] multiply(int[][] a, int constant) {

        int[][] c = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                c[i][j] = a[i][j] * constant;
            }
        }

        return c;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.value);
    }
}
