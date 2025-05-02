import java.util.*;

public class PairSum {
    public List<List<Integer>> findPairs(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        Set<String> uniquePairs = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int num : nums) {
            int complement = target - num;

            // If complement is seen before, then we have a valid pair
            if (seen.contains(complement)) {
                int min = Math.min(num, complement);
                int max = Math.max(num, complement);
                String pairKey = min + ":" + max;

                // Avoid duplicate pairs
                if (!uniquePairs.contains(pairKey)) {
                    result.add(Arrays.asList(min, max));
                    uniquePairs.add(pairKey);
                }
            }
            seen.add(num); // Add current number to seen
        }

        return result;
    }

    public static void main(String[] args) {
        PairSum obj = new PairSum();
        int[] arr = {1, 5, 7, -1, 5};
        int target = 6;
        System.out.println("Pairs with sum " + target + ": " + obj.findPairs(arr, target));
        // Output: [[1, 5], [-1, 7]]
    }
}
