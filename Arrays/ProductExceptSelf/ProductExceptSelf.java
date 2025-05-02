import java.util.*;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];  // product of all elements to the left of i
        int[] right = new int[n]; // product of all elements to the right of i
        int[] result = new int[n];

        // Compute left product array
        left[0] = 1; // nothing on the left of first element
        for (int i = 1; i < n; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        // Compute right product array
        right[n - 1] = 1; // nothing on the right of last element
        for (int i = n - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        // Final result: product of left[i] * right[i]
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductExceptSelf obj = new ProductExceptSelf();
        int[] arr = {1, 2, 3, 4};
        System.out.println("Product array: " + Arrays.toString(obj.productExceptSelf(arr))); // Output: [24,12,8,6]
    }
}
