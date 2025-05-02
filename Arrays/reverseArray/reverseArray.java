public class reverseArray {
    
    /**
     * Reverses the elements of an integer array in place
     * (modifies the original array rather than returning a new one)
     * @param arr The array to be reversed
     */
    public static void reverse(int[] arr) {
        // Initialize two pointers:
        // - 'start' at the beginning of the array (index 0)
        // - 'end' at the last element of the array (index length-1)
        int start = 0;
        int end = arr.length - 1;
        
        // Swap elements until the pointers meet in the middle
        while (start < end) {
            // Temporary variable to hold value during swap
            int temp = arr[start];
            arr[start] = arr[end];  // Move end element to start position
            arr[end] = temp;        // Move start element to end position
            
            // Move the pointers toward the center
            start++;
            end--;
        }
    }
    
    /**
     * Utility method to print an array
     * @param arr The array to be printed
     */
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test array
        int[] numbers = {1, 2, 3, 4, 5};
        
        System.out.println("Original array:");
        printArray(numbers);
        
        // Reverse the array
        reverse(numbers);
        
        System.out.println("Reversed array:");
        printArray(numbers);
        
        // Another test with even number of elements
        int[] numbers2 = {10, 20, 30, 40};
        System.out.println("\nOriginal array:");
        printArray(numbers2);
        
        reverse(numbers2);
        System.out.println("Reversed array:");
        printArray(numbers2);
    }
}