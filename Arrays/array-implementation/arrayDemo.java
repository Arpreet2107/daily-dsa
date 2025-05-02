// This code demonstrates the use of arrays in Java.
//         System.out.println("Element not found after " + comparisons + " comparisons");
public class arrayDemo {  // Fixed: Removed space in class name "Array Util" -> "ArrayUtil"
    
    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();  // Fixed: Changed System.err to System.out for consistency
    }

    public void arrayDemo() {
        int[] myArray = new int[6];  // Fixed: Changed size from 5 to 6 to accommodate all elements
        
        // Initialize array (commented out default values comment since it was incorrect)
        printArray(myArray);  // Will print all zeros (default int values)
        
        myArray[0] = 5;
        myArray[1] = 1;
        myArray[2] = 8;
        myArray[3] = 2;
        myArray[4] = 10;
        myArray[5] = 9;  // Now valid since array size is 6
        
        printArray(myArray);
        System.out.println("Array length: " + myArray.length);
        System.out.println("Last element: " + myArray[myArray.length - 1]);  // Fixed: Changed System.err to System.out
    }

    public static void main(String[] args) {
        arrayDemo arrUtil = new arrayDemo();
        arrUtil.arrayDemo();
    }
}