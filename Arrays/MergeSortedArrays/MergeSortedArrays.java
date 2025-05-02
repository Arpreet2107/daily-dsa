import java.util.Arrays;
//             nums[end] = temp;
/**
 * This class provides methods to merge two sorted arrays into a new sorted array.
 * The solution handles arrays of different lengths and maintains O(n+m) time complexity.
 */
public class MergeSortedArrays {

    /**
     * Merges two sorted arrays into one sorted array.
     * @param arr1 First sorted array
     * @param arr2 Second sorted array
     * @return New sorted array containing all elements from both inputs
     */
    public static int[] merge(int[] arr1, int[] arr2) {
        // Handle null arrays
        if (arr1 == null) return arr2 == null ? new int[0] : arr2.clone();
        if (arr2 == null) return arr1.clone();

        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        // Merge while both arrays have elements
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    /**
     * Alternative in-place merge for when arr1 has enough buffer space.
     * Assumes arr1 has enough space to hold all elements (including empty slots at end).
     */
    public static void mergeInPlace(int[] arr1, int m, int[] arr2, int n) {
        int p1 = m - 1; // Last element of arr1 content
        int p2 = n - 1; // Last element of arr2
        int p = m + n - 1; // Last position of merged array

        // Merge from the end
        while (p1 >= 0 && p2 >= 0) {
            if (arr1[p1] > arr2[p2]) {
                arr1[p--] = arr1[p1--];
            } else {
                arr1[p--] = arr2[p2--];
            }
        }

        // Copy remaining elements from arr2
        while (p2 >= 0) {
            arr1[p--] = arr2[p2--];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8, 10};

        int[] merged = merge(arr1, arr2);
        System.out.println("Merged array: " + Arrays.toString(merged));

        // Test in-place merge
        int[] arr1WithSpace = new int[10];
        System.arraycopy(arr1, 0, arr1WithSpace, 0, arr1.length);
        mergeInPlace(arr1WithSpace, arr1.length, arr2, arr2.length);
        System.out.println("In-place merged: " + Arrays.toString(arr1WithSpace));
    }
}