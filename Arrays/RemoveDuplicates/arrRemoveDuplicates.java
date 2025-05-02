/**
 * This class provides methods to remove duplicates from a sorted array in-place.
 * The solution maintains O(1) space complexity by modifying the original array.
 */
public class arrRemoveDuplicates {

    /**
     * Removes duplicates from a sorted integer array in-place.
     * Returns the new length of the array without duplicates.
     * 
     * @param nums The sorted input array (will be modified)
     * @return The length of the array after duplicate removal
     * @throws IllegalArgumentException if the input array is null
     */
    public static int removeDuplicates(int[] nums) {
        // Validate input
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        
        // Handle empty array case
        if (nums.length == 0) {
            return 0;
        }

        // Initialize pointer for unique elements
        int uniqueIndex = 0;
        
        // Iterate through the array starting from second element
        for (int current = 1; current < nums.length; current++) {
            // When a new unique element is found
            if (nums[current] != nums[uniqueIndex]) {
                // Move the unique pointer forward
                uniqueIndex++;
                // Copy the new unique element to its correct position
                nums[uniqueIndex] = nums[current];
            }
            // If elements are equal, we simply continue to next element
        }
        
        // The new length is the position of last unique element + 1
        return uniqueIndex + 1;
    }

    /**
     * Helper method to print array up to a given length
     */
    private static void printArray(int[] nums, int length) {
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i]);
            if (i < length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Test cases
        int[] test1 = {1, 1, 2, 2, 3, 4, 4, 4, 5};
        System.out.println("Original array:");
        printArray(test1, test1.length);
        
        int newLength = removeDuplicates(test1);
        System.out.println("After removing duplicates:");
        printArray(test1, newLength);
        System.out.println("New length: " + newLength);
        
        // Edge cases
        int[] empty = {};
        try {
            System.out.println("\nTesting empty array:");
            printArray(empty, removeDuplicates(empty));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        int[] allSame = {7, 7, 7, 7};
        System.out.println("\nTesting all identical elements:");
        printArray(allSame, removeDuplicates(allSame));
    }
}