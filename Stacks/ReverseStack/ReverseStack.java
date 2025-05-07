// File: ReverseStack.java

import java.util.Stack;

public class ReverseStack {

    // Insert element at the bottom (helper method)
    static void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack, value);
        stack.push(top);
    }

    // Main reverse function
    static void reverse(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            reverse(stack); // Reverse rest of stack
            insertAtBottom(stack, top); // Insert current at bottom
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack: " + stack);
        reverse(stack);
        System.out.println("Reversed Stack: " + stack);
    }
}
