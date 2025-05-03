public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if first row has any zero
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check if first column has any zero
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Use first row and first column as markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set elements to zero based on markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        // Set first row to zero if needed
        if (firstRowZero) {
            for (int j = 0; j < cols; j++)
                matrix[0][j] = 0;
        }

        // Set first column to zero if needed
        if (firstColZero) {
            for (int i = 0; i < rows; i++)
                matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        SetMatrixZero obj = new SetMatrixZero();
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        obj.setZeroes(matrix);

        System.out.println("Matrix after setting zeros:");
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
        // Output:
        // 1 0 1
        // 0 0 0
        // 1 0 1
    }
}
