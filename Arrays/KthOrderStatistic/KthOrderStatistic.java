// This code demonstrates the use of arrays in Java.
//         System.out.println("Element not found after " + comparisons + " comparisons");
import java.util.PriorityQueue;
import java.util.Random;

/**
 * This class provides multiple approaches to find the Kth largest/smallest element,
 * including QuickSelect (optimized) and PriorityQueue solutions.
 */
public class KthOrderStatistic {
    /**
     * Finds the Kth smallest element using sorting (O(n log n) time complexity)
     * @param nums The input array
     * @param k The order statistic to find (1-based index)
     * @return The Kth smallest element
     */

    /**
     * Finds the Kth smallest element using QuickSelect algorithm (O(n) average case)
     * @param nums The input array
     * @param k The order statistic to find (1-based index)
     * @return The Kth smallest element
     */
    public static int findKthSmallest(int[] nums, int k) {
        if (nums == null || k < 1 || k > nums.length) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    /**
     * Finds the Kth largest element using QuickSelect
     * @param nums The input array
     * @param k The order statistic to find (1-based index)
     * @return The Kth largest element
     */
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || k < 1 || k > nums.length) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }

        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left);

        pivotIndex = partition(nums, left, right, pivotIndex);

        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        swap(nums, right, storeIndex);
        return storeIndex;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Alternative solution using MinHeap for Kth largest element
     * Time Complexity: O(n log k)
     */
    public static int findKthLargestWithHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        
        System.out.println(k + "nd smallest: " + findKthSmallest(nums, k));
        System.out.println(k + "nd largest: " + findKthLargest(nums, k));
        System.out.println(k + "nd largest (heap): " + findKthLargestWithHeap(nums, k));
    }
}