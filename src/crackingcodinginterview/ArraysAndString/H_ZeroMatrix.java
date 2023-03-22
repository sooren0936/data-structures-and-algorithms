package crackingcodinginterview.ArraysAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Zero Matrix:
 * Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and olumn are set to 0.
 */
public class H_ZeroMatrix {

    public static void main(final String[] args) {
        final int[][] matrix3x3 = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };
        zeroMatrix(matrix3x3);

        final int[][] matrix5x5 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 0, 14, 15},
                {0, 17, 18, 19, 20},
                {21, 22, 23, 0, 25}
        };
        zeroMatrix(matrix5x5);
    }

    private static void zeroMatrix(final int[][] matrix) {
        long currentTimeMillis;

        currentTimeMillis = System.currentTimeMillis();
        matrixToString(solution(matrix));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    private static void matrixToString(final int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("");
    }


    public static int[][] solution(final int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new RuntimeException("Matrix can't be null or empty");
        }

        final List<PositionOfTwoDimensionalArrayElement> positionOfTwoDimensionalArrayElements = findNullablePositions(matrix);
        return setToZeroElements(matrix, positionOfTwoDimensionalArrayElements);
    }

    private static int[][] setToZeroElements(final int[][] matrix, final List<PositionOfTwoDimensionalArrayElement> positionOfTwoDimensionalArrayElements) {
        for (PositionOfTwoDimensionalArrayElement positionOfTwoDimensionalArrayElement : positionOfTwoDimensionalArrayElements) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[positionOfTwoDimensionalArrayElement.first][i] = 0;
                matrix[i][positionOfTwoDimensionalArrayElement.second] = 0;
            }
        }
        return matrix;
    }

    private static List<PositionOfTwoDimensionalArrayElement> findNullablePositions(final int[][] matrix) {
        final List<PositionOfTwoDimensionalArrayElement> positionOfTwoDimensionalArrayElements = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    positionOfTwoDimensionalArrayElements.add(new PositionOfTwoDimensionalArrayElement(i, j));
                }
            }
        }
        return positionOfTwoDimensionalArrayElements;
    }

    public record PositionOfTwoDimensionalArrayElement(int first, int second) {
    }
}
