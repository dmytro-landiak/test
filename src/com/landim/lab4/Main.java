package com.landim.lab4;

import com.landim.lab4.Matrix;
import com.landim.lab4.MatrixUtil;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void start() throws IOException, SAXException, ParserConfigurationException {
//
//        int[][] matrix =  new int[][]   {{3, 2, 1, 0},
//                                        {2, 2, -1},
//                                        {1, 2, -3, 5, -8}};
//
//
//        System.out.println("Before sorting:\n" + Arrays.deepToString(matrix));
//        MatrixUtil.sortMatrixRows(matrix);
//
//        System.out.println("After sorting:\n" + Arrays.deepToString(matrix));
//        System.out.println("Sum: " + MatrixUtil.computeMinMaxColumnsSum(matrix));
//
//        int element = -1;
//        int rowIndex = 0;
//        for(long count : MatrixUtil.amountOfGreaterElements(matrix, element)) {
//            System.out.println(String.format("Row: %d, elements: %d", rowIndex++, count));
//        }


//        Matrix firstMatrix = new Matrix(new int[][]   {{1, 2},
//                                                        {2, 3},
//                                                        {3, 2, 3}});
//
//        Matrix secondMatrix = new Matrix(new int[][]   {{1, 2, 3},
//                                                        {2, 3, 1}});
//
//        Matrix thirdMatrix = new Matrix(new int[][]   {{-1, 7, 3},
//                                                        {2, 3, 7}});

//        System.out.println(secondMatrix.multuply(thirdMatrix));
//        System.out.println(firstMatrix.multiply(10));

        int[][][] coube = { {{1, 2, 3},
                            {1, 2, 3},
                            {1, 2, 3}},

                            {{2, 3, 4},
                            {2, 3, 4},
                            {2, 3, 4}},

                            {{3, 4, 5},
                            {3, 4, 5},
                            {3, 4, 5}}
        };


        int[][] result = matrixMultiply(matrixMultiply(coube[0], coube[1]), coube[2]);
        System.out.println(Arrays.deepToString(result));

    }


    /**
     * Multiplies matrixes
     * @param A - left matrix
     * @param B - right matrix
     * @return result of multiplying
     */
    public static int[][] matrixMultiply(int[][] A, int[][] B) {

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
}