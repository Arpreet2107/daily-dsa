// File: ValidateStackSequence.java

import java.util.Stack;

public class ValidateStackSequence {

    // Function to check if push/pop sequences are valid
    static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // Index for popped[]

        for (int value : pushed) {
            stack.push(value); // push into stack

            // Try to match stack top with popped[j]
            while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        // If stack is empty, it was valid
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};

        System.out.println("Is Valid Stack Sequence: " + validateStackSequences(pushed, popped));
    }
}
