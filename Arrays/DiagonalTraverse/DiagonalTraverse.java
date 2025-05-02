import java.util.*;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];

        int rows = mat.length;
        int cols = mat[0].length;
        int[] result = new int[rows * cols];
        int idx = 0;

        // There are rows + cols - 1 diagonals
        for (int d = 0; d < rows + cols - 1; d++) {
            List<Integer> intermediate = new ArrayList<>();

            int r = (d < cols) ? 0 : d - cols + 1;
            int c = (d < cols) ? d : cols - 1;

            while (r < rows && c >= 0) {
                intermediate.add(mat[r][c]);
                r++;
                c--;
            }

            // Reverse the list for even diagonals
            if (d % 2 == 0) Collections.reverse(intermediate);

            for (int val : intermediate) {
                result[idx++] = val;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        DiagonalTraverse obj = new DiagonalTraverse();
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Diagonal Traversal: " + Arrays.toString(obj.findDiagonalOrder(mat)));
        // Output: [1,2,4,7,5,3,6,8,9]
    }
}
