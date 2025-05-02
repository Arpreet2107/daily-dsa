/**
 * This class provides methods to find second largest and smallest elements in an array.
 * The solutions handle edge cases and maintain optimal O(n) time complexity.
 */
public class SecondOrderElements {

    /**
     * Finds the second largest element in the array.
     * @param arr The input array (can contain duplicates)
     * @return The second largest element
     * @throws IllegalArgumentException if array has less than 2 elements
     */
    public static int findSecondLargest(int[] arr) {
        // Validate input
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest; // Current largest becomes second largest
                largest = num;         // Update largest with new value
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;    // Update second largest
            }
        }

        // Check if we actually found a second largest
        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("All elements are identical");
        }

        return secondLargest;
    }

    /**
     * Finds the second smallest element in the array.
     * @param arr The input array (can contain duplicates)
     * @return The second smallest element
     * @throws IllegalArgumentException if array has less than 2 elements
     */
    public static int findSecondSmallest(int[] arr) {
        // Validate input
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < smallest) {
                secondSmallest = smallest; // Current smallest becomes second smallest
                smallest = num;           // Update smallest with new value
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num;     // Update second smallest
            }
        }

        // Check if we actually found a second smallest
        if (secondSmallest == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("All elements are identical");
        }

        return secondSmallest;
    }

    public static void main(String[] args) {
        // Test cases
        int[] test1 = {12, 35, 1, 10, 34, 1};
        System.out.println("Second largest in test1: " + findSecondLargest(test1));
        System.out.println("Second smallest in test1: " + findSecondSmallest(test1));

        int[] test2 = {5, 5, 5, 5, 5};
        try {
            System.out.println("Second largest in test2: " + findSecondLargest(test2));
        } catch (IllegalArgumentException e) {
            System.out.println("Error with test2: " + e.getMessage());
        }
    }
}