package crackingcodinginterview.ArraysAndString;

import java.util.Arrays;

/**
 * Rotate Matrix: Given an image represented by an NxN matrix,
 * where each pixel in the image is 4bytes,
 * write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 */
public class G_RotateMatrix {

    public static void main(final String[] args) {
        final int[][] matrix3x3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotateMatrix(matrix3x3);

        final int[][] matrix5x5 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        rotateMatrix(matrix5x5);
    }

    private static void rotateMatrix(final int[][] matrix) {
        int[][] matrix90 = solutionRotateToRight(matrix);
        int[][] matrix180 = solutionRotateToRight(matrix90);
        int[][] matrix270 = solutionRotateToRight(matrix180);
        int[][] matrix360 = solutionRotateToRight(matrix270);
        matrixToString(matrix90);
        matrixToString(matrix180);
        matrixToString(matrix270);
        matrixToString(matrix360);
    }

    private static void matrixToString(final int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("");
    }


    public static int[][] solutionRotateToRight(final int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new RuntimeException("Matrix can't be null or empty");
        }

        final int[][] matrixNew = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrixNew[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }
        return matrixNew;
    }
}
