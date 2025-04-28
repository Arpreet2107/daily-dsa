package TwoSumPrblm;
//Two Sum Problem:
//Problem: Given an array of integers, find two numbers such that they add up to a specific target number.
import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};  // Return indices of two numbers
            }
            map.put(nums[i], i);
        }
        return new int[]{};  // No solution found
    }

    public static void main(String[] args) {
        // Input format: First line contains the number of elements (n), second line contains the target sum,
        // followed by n integers representing the array elements.
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();  // Number of elements in array
            int target = sc.nextInt();  // Target sum
            
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int[] result = twoSum(nums, target);
            if (result.length == 2) {
                System.out.println(result[0] + " " + result[1]);
            } else {
                System.out.println("No solution found");
            }
        }
    }

    
}

