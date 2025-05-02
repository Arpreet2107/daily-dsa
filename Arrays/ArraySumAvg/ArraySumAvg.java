/**
 * This class demonstrates how to calculate the sum and average of array elements.
 */
public class ArraySumAvg {

    /**
     * Calculates the sum of all elements in an integer array.
     * @param arr The input array
     * @return The sum of all elements
     * @throws IllegalArgumentException if the array is null
     */
    public static int calculateSum(int[] arr) {
        // Check for null array edge case
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int sum = 0;

        // Enhanced for loop to iterate through all elements
        for (int num : arr) {
            sum += num; // Accumulate the sum
        }

        return sum;
    }

    /**
     * Calculates the average of all elements in an integer array.
     * @param arr The input array
     * @return The average as a double value
     * @throws IllegalArgumentException if array is null or empty
     */
    public static double calculateAverage(int[] arr) {
        // Check for null or empty array edge cases
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        // Calculate sum using our existing method
        int sum = calculateSum(arr);

        // Cast sum to double before division to get precise result
        return (double) sum / arr.length;
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        // Calculate and print sum
        try {
            System.out.println("Sum of elements: " + calculateSum(numbers));
        } catch (IllegalArgumentException e) {
            System.out.println("Error calculating sum: " + e.getMessage());
        }

        // Calculate and print average
        try {
            double average = calculateAverage(numbers);
            System.out.printf("Average of elements: %.2f\n", average);
        } catch (IllegalArgumentException e) {
            System.out.println("Error calculating average: " + e.getMessage());
        }
    }
}