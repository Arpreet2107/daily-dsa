// File: InsertAtBottom.java

import java.util.Stack;

public class InsertAtBottom {

    // Function to insert element at bottom of stack
    static void insertAtBottom(Stack<Integer> stack, int value) {
        // Base case: if stack is empty, push the value
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        // Hold all items in Function Call Stack until we reach the bottom
        int top = stack.pop();
        insertAtBottom(stack, value);

        // After inserting value at bottom, push all top items back
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Original Stack: " + stack);
        insertAtBottom(stack, 5);
        System.out.println("After inserting 5 at bottom: " + stack);
    }
}
