import java.util.Arrays;

/**
 * This class provides methods to rotate an array by k positions.
 * Includes three different approaches with optimizations.
 */
public class RotateArray {

    /**
     * Rotates the array to the right by k positions using reversal algorithm.
     * This is the most space-efficient O(1) space solution.
     * 
     * @param nums The array to rotate (will be modified)
     * @param k The number of positions to rotate
     * @throws IllegalArgumentException if input array is null or k is negative
     */
    public static void rotate(int[] nums, int k) {
        // Validate inputs
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        if (k < 0) {
            throw new IllegalArgumentException("Rotation count cannot be negative");
        }
        
        // Handle empty array or no rotation needed
        if (nums.length == 0 || k == 0) {
            return;
        }
        
        // Normalize k to be within array bounds
        k = k % nums.length;
        
        // If normalized k is 0, no rotation needed
        if (k == 0) {
            return;
        }
        
        // Step 1: Reverse the entire array
        reverse(nums, 0, nums.length - 1);
        
        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);
        
        // Step 3: Reverse the remaining elements
        reverse(nums, k, nums.length - 1);
    }
    
    /**
     * Helper method to reverse a portion of an array
     * 
     * @param nums The array to modify
     * @param start The starting index (inclusive)
     * @param end The ending index (inclusive)
     */
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // Swap elements at start and end indices
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            
            // Move pointers towards center
            start++;
            end--;
        }
    }

    /**
     * Alternative rotation method using temporary array
     * (More intuitive but uses O(n) space)
     */
    public static void rotateWithTempArray(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return;
        }
        
        k = k % nums.length;
        int[] temp = new int[nums.length];
        
        // Copy elements to temp array in rotated positions
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        
        // Copy back to original array
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        // Test rotation
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        
        System.out.println("Original array:");
        System.out.println(Arrays.toString(numbers));
        
        rotate(numbers, k);
        System.out.println("After rotating right by " + k + " positions:");
        System.out.println(Arrays.toString(numbers));
        
        // Test edge cases
        System.out.println("\nTesting edge cases:");
        
        int[] empty = {};
        try {
            rotate(empty, 2);
            System.out.println("Empty array rotation: " + Arrays.toString(empty));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        int[] single = {42};
        rotate(single, 5);
        System.out.println("Single element rotation: " + Arrays.toString(single));
        
        // Compare both rotation methods
        int[] test1 = {1, 2, 3, 4, 5};
        int[] test2 = Arrays.copyOf(test1, test1.length);
        
        rotate(test1, 2);
        rotateWithTempArray(test2, 2);
        
        System.out.println("\nComparison of rotation methods:");
        System.out.println("Reversal method: " + Arrays.toString(test1));
        System.out.println("Temp array method: " + Arrays.toString(test2));
    }
}