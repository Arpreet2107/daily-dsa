import java.util.ArrayList;
import java.util.List;

/**
 * This class provides spiral order traversal for 2D matrices with comprehensive
 * handling of edge cases and rectangular matrices.
 */
public class SpiralMatrixTraversal {

    /**
     * Returns elements of the matrix in spiral order
     * @param matrix The 2D input matrix
     * @return List of elements in spiral order
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right on top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom on right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Make sure we still have rows to traverse
            if (top <= bottom) {
                // Traverse from right to left on bottom row
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Make sure we still have columns to traverse
            if (left <= right) {
                // Traverse from bottom to top on left column
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    /**
     * Generates a matrix filled with numbers in spiral order
     * @param n The size of the n x n matrix
     * @return The generated spiral matrix
     */
    public static int[][] generateSpiralMatrix(int n) {
        int[][] matrix = new int[n][n];
        int value = 1;
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // Top row (left to right)
            for (int i = left; i <= right; i++) {
                matrix[top][i] = value++;
            }
            top++;

            // Right column (top to bottom)
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = value++;
            }
            right--;

            // Bottom row (right to left)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = value++;
                }
                bottom--;
            }

            // Left column (bottom to top)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = value++;
                }
                left++;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        System.out.println("Spiral order traversal:");
        System.out.println(spiralOrder(matrix));

        System.out.println("\nGenerated spiral matrix:");
        int[][] spiral = generateSpiralMatrix(4);
        for (int[] row : spiral) {
            for (int num : row) {
                System.out.printf("%3d", num);
            }
            System.out.println();
        }
    }
}