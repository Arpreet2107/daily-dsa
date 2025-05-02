public class SearchMatrix {
    public boolean search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start from top-right corner
        int i = 0, j = cols - 1;

        while (i < rows && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)
                j--; // Move left
            else
                i++; // Move down
        }

        return false;
    }

    public static void main(String[] args) {
        SearchMatrix obj = new SearchMatrix();
        int[][] matrix = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };
        int target = 29;
        System.out.println("Target found: " + obj.search(matrix, target)); // true
    }
}
