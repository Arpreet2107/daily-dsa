import java.util.ArrayList;
import java.util.Arrays;

public class removeEvenInteger {
    
    public static int[] removeEvenNumbers(int[] arr) {
        // Create an ArrayList to store odd numbers dynamically
        ArrayList<Integer> oddList = new ArrayList<>();
        
        // Iterate through the array and add odd numbers to the list
        for (int num : arr) {
            if (num % 2 != 0) {
                oddList.add(num);
            }
        }
        
        // Convert ArrayList back to array
        int[] result = new int[oddList.size()];
        for (int i = 0; i < oddList.size(); i++) {
            result[i] = oddList.get(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        System.out.println("Original array: " + Arrays.toString(numbers));
        
        int[] oddNumbers = removeEvenNumbers(numbers);
        
        System.out.println("Array after removing even numbers: " + Arrays.toString(oddNumbers));
    }
}

//Version 2: Using Java Streams (More modern approach)
// import java.util.Arrays;

// public class RemoveEvenIntegersStream {
    
//     /**
//      * Removes even integers using Java Streams API (Java 8+)
//      * @param arr The input array of integers
//      * @return A new array containing only the odd integers from the input
//      */
//     public static int[] removeEvenNumbers(int[] arr) {
//         // Convert the array to a stream of integers
//         return Arrays.stream(arr)
//                    // Use filter() to keep only elements that match our condition
//                    // The lambda expression n -> n % 2 != 0 checks for odd numbers
//                    .filter(n -> n % 2 != 0)
//                    // Convert the stream back to an array
//                    .toArray();
//     }

//     public static void main(String[] args) {
//         // Test array
//         int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
//         System.out.println("Original array: " + Arrays.toString(numbers));
        
//         // The stream version is more concise but does the same thing
//         int[] oddNumbers = removeEvenNumbers(numbers);
        
//         System.out.println("Array after removing even numbers: " + Arrays.toString(oddNumbers));
//     }
// }