// File: SortStackRecursively.java

import java.util.Stack;

public class SortStackRecursively {

    // Function to sort stack recursively
    static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();  // Remove top
            sortStack(stack);        // Sort remaining stack
            insertInSortedOrder(stack, temp);  // Insert in sorted order
        }
    }

    // Insert element into sorted stack
    static void insertInSortedOrder(Stack<Integer> stack, int val) {
        if (stack.isEmpty() || val > stack.peek()) {
            stack.push(val);  // Place value if correct position
        } else {
            int temp = stack.pop();  // Remove top and recurse
            insertInSortedOrder(stack, val);
            stack.push(temp);       // Put back original top
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(5);
        s.push(20);
        s.push(10);

        sortStack(s);

        System.out.println("Sorted Stack:");
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
