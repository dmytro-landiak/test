package com.landim.lab4;

import java.util.Arrays;
import java.util.stream.Stream;


public final class MatrixUtil {

    private MatrixUtil() {}

    /**
     * Sorts rows of given matrix.
     * @param matrix matrix to be sorted.
     */
    public static void sortMatrixRows(int[][] matrix) {

        if(matrix == null) {
            throw new IllegalArgumentException("Matrix can not be null");
        }

        if(matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Matrix can not be empty");
        }

        for(int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
        }
    }

    /**
     * Computes sum of minimal and maximal elements of each column.
     * @return sum of minimal and maximal elements of each column.
     */
    public static int computeMinMaxColumnsSum(int[][] matrix) {

        if(matrix == null) {
            throw new IllegalArgumentException("Matrix can not be null");
        }

        if(matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Matrix can not be empty");
        }

        int maxWidth = 0;
        for(int i = 0; i < matrix.length; i++) {
            if(maxWidth < matrix[i].length) {
                maxWidth = matrix[i].length;
            }
        }

        int result = 0;
        for(int i = 0; i < maxWidth; i++) {

            int columnMinimal = Integer.MAX_VALUE;
            int columnMaximal = Integer.MIN_VALUE;
            for(int j = 0; j < matrix.length; j++) {
                if(i < matrix[j].length) {

                    if(columnMinimal > matrix[j][i]) {
                        columnMinimal = matrix[j][i];
                    }

                    if(columnMaximal < matrix[j][i]) {
                        columnMaximal = matrix[j][i];
                    }
                }
            }
//            System.out.println("Column: " + i + "Min: " + columnMinimal);
//            System.out.println("Column: " + i + "Max: " + columnMaximal);

            result += columnMinimal + columnMaximal;
        }

        return result;
    }

    public static long[] amountOfGreaterElements(int[][] matrix, final int element) {

        if(matrix == null) {
            throw new IllegalArgumentException("Matrix can not be null");
        }

        if(matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Matrix can not be empty");
        }

        long[] result = new long[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            result[i] = Arrays.stream(matrix[i]).filter((el) -> el > element).count();
        }

        return result;
    }



}
