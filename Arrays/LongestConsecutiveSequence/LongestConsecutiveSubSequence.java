import java.util.HashSet;
import java.util.Set;

/**
 * This class solves the longest consecutive subsequence problem using HashSet for O(n) time complexity.
 * The algorithm efficiently finds the longest sequence of consecutive numbers in an unsorted array.
 */
public class LongestConsecutiveSubSequence {

    /**
     * Finds the length of the longest consecutive elements sequence.
     * @param nums The input array of integers (may contain duplicates)
     * @return Length of the longest consecutive sequence
     * @throws IllegalArgumentException if input array is null
     */
    public static int longestConsecutive(int[] nums) {
        // Validate input
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        // Handle empty array case
        if (nums.length == 0) {
            return 0;
        }

        // Create a HashSet for O(1) lookups
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Iterate through each unique number in the set
        for (int num : numSet) {
            // Only start counting if this is the first number of a potential sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count how many consecutive numbers follow this one
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest streak found
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    /**
     * Alternative implementation with additional tracking of the actual sequence
     * @return Array containing [length, startValue, endValue] of longest sequence
     */
    public static int[] longestConsecutiveWithDetails(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{0, 0, 0};
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);

        int longestLength = 1;
        int bestStart = nums[0];
        int bestEnd = nums[0];

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int current = num;
                int end = num;
                int length = 1;

                while (numSet.contains(current + 1)) {
                    current++;
                    end = current;
                    length++;
                }

                if (length > longestLength) {
                    longestLength = length;
                    bestStart = num;
                    bestEnd = end;
                }
            }
        }

        return new int[]{longestLength, bestStart, bestEnd};
    }

    public static void main(String[] args) {
        int[] test1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive sequence length: " + 
            longestConsecutive(test1));

        int[] details = longestConsecutiveWithDetails(test1);
        System.out.printf("Details: length=%d, from %d to %d\n", 
            details[0], details[1], details[2]);

        // Edge case with duplicates
        int[] test2 = {0, 0, -1};
        System.out.println("With duplicates: " + longestConsecutive(test2));
    }
}