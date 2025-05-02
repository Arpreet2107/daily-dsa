import java.util.*;

public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        // Iterate over array
        for (int num : nums) {
            // If number is already in set, it's a duplicate
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        // Convert to list
        return new ArrayList<>(duplicates);
    }

    public static void main(String[] args) {
        FindDuplicates obj = new FindDuplicates();
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Duplicate numbers: " + obj.findDuplicates(arr)); // Output: [2, 3]
    }
}
