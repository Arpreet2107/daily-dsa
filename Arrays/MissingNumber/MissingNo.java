public class MissingNo {
    public int findMissing(int[] nums) {
        int n = nums.length + 1; // because one number is missing
        int totalSum = n * (n + 1) / 2; // sum of first n natural numbers
        int actualSum = 0;

        // Calculate the sum of elements in the array
        for (int num : nums) {
            actualSum += num;
        }

        // The missing number is the difference
        return totalSum - actualSum;
    }

    public static void main(String[] args) {
        MissingNo obj = new MissingNo();
        int[] arr = {1, 2, 4, 5, 6};
        System.out.println("Missing number: " + obj.findMissing(arr)); // Output: 3
    }
}
