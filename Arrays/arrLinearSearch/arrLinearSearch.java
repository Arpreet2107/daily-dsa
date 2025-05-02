/**
 * This class provides implementation for linear search operation in arrays.
 * Linear search checks each element sequentially until the target is found.
 */
public class arrLinearSearch {

    /**
     * Performs linear search on an integer array.
     * 
     * @param arr The array to be searched (can be unsorted)
     * @param target The value to search for
     * @return The index of the target if found, -1 otherwise
     * @throws IllegalArgumentException if the input array is null
     */
    public static int search(int[] arr, int target) {
        // Validate input array
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // Check if current element matches the target
            if (arr[i] == target) {
                // Return the index where element was found
                return i;
            }
        }

        // If we reach here, the element was not found
        return -1;
    }

    /**
     * Enhanced version with early exit for empty array and additional diagnostics
     */
    public static int searchWithDiagnostics(int[] arr, int target) {
        // Handle edge cases
        if (arr == null) {
            System.err.println("Error: Null array provided");
            return -1;
        }
        
        if (arr.length == 0) {
            System.out.println("Warning: Empty array provided");
            return -1;
        }

        System.out.println("Starting linear search for target: " + target);
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Found after " + comparisons + " comparisons");
                System.out.println("Element found at index: " + i);
                return i;
            }
        }

        System.out.println("Target not found after " + comparisons + " comparisons");
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 2, 7, 1, 9, 5, 8, 3, 6};
        int target = 5;

        // Basic search
        int result = search(numbers, target);
        if (result != -1) {
            System.out.println("Basic search: Found at index " + result);
        } else {
            System.out.println("Basic search: Not found");
        }

        // Search with diagnostics
        searchWithDiagnostics(numbers, target);
        
        // Test edge cases
        searchWithDiagnostics(new int[0], target); // Empty array
        searchWithDiagnostics(null, target);       // Null array
    }
}