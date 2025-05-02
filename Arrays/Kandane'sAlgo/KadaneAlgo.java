/**
 * This class implements Kadane's algorithm to find the maximum subarray sum.
 * Includes variations to also find the subarray indices and handle all-negative arrays.
 */
public class KadaneAlgo{

    /**
     * Finds the maximum sum of any contiguous subarray.
     * @param nums Input array of integers
     * @return Maximum subarray sum
     * @throws IllegalArgumentException if input array is null or empty
     */
    public static int maxSubArraySum(int[] nums) {
        // Validate input
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to start new subarray or continue current
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            // Update global maximum
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    /**
     * Enhanced version that also returns the subarray indices.
     * @return Array containing [maxSum, startIndex, endIndex]
     */
    public static int[] maxSubArrayWithIndices(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        int start = 0, end = 0;
        int tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxEndingHere + nums[i]) {
                maxEndingHere = nums[i];
                tempStart = i; // New subarray starts here
            } else {
                maxEndingHere += nums[i];
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }

        return new int[]{maxSoFar, start, end};
    }

    public static void main(String[] args) {
        int[] test1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum: " + maxSubArraySum(test1));

        int[] result = maxSubArrayWithIndices(test1);
        System.out.printf("Max sum: %d, from index %d to %d\n",
                result[0], result[1], result[2]);

        // Test edge cases
        int[] allNegative = {-5, -3, -2, -8};
        System.out.println("All negative array max: " + maxSubArraySum(allNegative));
    }
}