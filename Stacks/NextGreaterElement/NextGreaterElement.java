// File: NextGreaterElement.java

import java.util.Stack;

public class NextGreaterElement {

    // Function to print next greater element for every element in array
    static void printNextGreaterElements(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        int[] result = new int[arr.length];

        // Traverse from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];

            // Pop all elements smaller than or equal to current
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // If stack is empty, then no greater element to right
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element to stack
            stack.push(current);
        }

        // Print result
        System.out.println("Next Greater Elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " -> " + result[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25, 7, 8};
        printNextGreaterElements(arr);
    }
}
