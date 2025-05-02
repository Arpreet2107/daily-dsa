/**
 * This class provides methods to count occurrences of a number in an array.
 */
public class arrCountOcc {

    /**
     * Counts how many times a target number appears in the array.
     * 
     * @param arr The array to search (can contain duplicates)
     * @param target The number to count occurrences of
     * @return The count of target occurrences
     * @throws IllegalArgumentException if input array is null
     */
    public static int count(int[] arr, int target) {
        // Validate input
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        int count = 0;

        // Enhanced for loop to iterate through all elements
        for (int num : arr) {
            if (num == target) {
                count++; // Increment count for each match
            }
        }

        return count;
    }

    /**
     * Enhanced version with frequency analysis for all elements
     */
    public static void analyzeFrequency(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("No elements to analyze");
            return;
        }

        // We'll track already counted elements to avoid duplicate reporting
        boolean[] counted = new boolean[arr.length];

        System.out.println("Frequency Analysis:");
        for (int i = 0; i < arr.length; i++) {
            if (!counted[i]) {
                int current = arr[i];
                int currentCount = 1;

                // Count duplicates of this element
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == current) {
                        currentCount++;
                        counted[j] = true; // Mark as counted
                    }
                }

                System.out.printf("Element %d occurs %d time%s\n", 
                    current, currentCount, (currentCount > 1 ? "s" : ""));
                counted[i] = true;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {2, 5, 2, 6, 2, 7, 2, 8, 2, 5, 9, 5};
        int target = 5;

        // Basic count
        try {
            int occurrences = count(numbers, target);
            System.out.println("Number " + target + " appears " + 
                occurrences + " times");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Full frequency analysis
        analyzeFrequency(numbers);
        
        // Test edge cases
        analyzeFrequency(new int[0]); // Empty array
        analyzeFrequency(null);       // Null array
    }
}