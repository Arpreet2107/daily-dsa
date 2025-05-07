// File: CloneStack.java

import java.util.Stack;

public class CloneStack {

    // Function to insert at bottom
    static void insertAtBottom(Stack<Integer> s, int item) {
        if (s.isEmpty()) {
            s.push(item);
            return;
        }

        int top = s.pop();
        insertAtBottom(s, item);
        s.push(top);
    }

    // Recursive function to clone
    static void cloneStack(Stack<Integer> original) {
        if (original.isEmpty()) return;

        int top = original.pop();
        cloneStack(original);
        insertAtBottom(original, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Original Stack: " + stack);

        // Clone using recursion
        cloneStack(stack);

        System.out.println("Cloned Stack: " + stack); // Stack restored in original order
    }
}
