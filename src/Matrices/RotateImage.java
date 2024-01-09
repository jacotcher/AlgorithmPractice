package Matrices;

public class RotateImage {
    public static int[][] rotateImage(int[][] matrix) {

        int n = matrix.length;

        for (int row = 0; row < n / 2; row++) {
            for (int col = row; col < n - row - 1; col++) {
                int topLeft = matrix[row][col];
                int topRight = matrix[col][n-1-row];
                int bottomright = matrix[n-1-row][n-1-col];
                int bottomLeft = matrix[n-1-col][row];

                matrix[col][n-1-row] = topLeft;
                matrix[n-1-row][n-1-col] = topRight;
                matrix[n-1-col][row] = bottomright;
                matrix[row][col] = bottomLeft;
            }

        }
        return matrix;
    }
}
