/**
 * This class demonstrates how to find the maximum and minimum elements in an array.
 */
public class ArrayMinMax {

    /**
     * Finds the maximum element in an integer array.
     * @param arr The input array
     * @return The maximum value in the array
     * @throws IllegalArgumentException if the array is empty
     */
    public static int findMax(int[] arr) {
        // Check for empty array edge case
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        // Initialize max with first element
        int max = arr[0];

        // Loop through each element starting from the second one
        for (int i = 1; i < arr.length; i++) {
            // If current element is greater than max, update max
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    /**
     * Finds the minimum element in an integer array.
     * @param arr The input array
     * @return The minimum value in the array
     * @throws IllegalArgumentException if the array is empty
     */
    public static int findMin(int[] arr) {
        // Check for empty array edge case
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        // Initialize min with first element
        int min = arr[0];

        // Loop through each element starting from the second one
        for (int i = 1; i < arr.length; i++) {
            // If current element is smaller than min, update min
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] numbers = {12, 45, 67, 23, 9, 54, 32};

        // Find and print maximum
        try {
            System.out.println("Maximum element: " + findMax(numbers));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Find and print minimum
        try {
            System.out.println("Minimum element: " + findMin(numbers));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}