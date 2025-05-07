// File: StackWithMin.java

import java.util.Stack;

public class StackWithMin {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    // Push operation
    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // Pop operation
    public int pop() {
        int popped = mainStack.pop();
        if (popped == minStack.peek()) {
            minStack.pop(); // Maintain min stack
        }
        return popped;
    }

    // Get minimum in O(1)
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackWithMin s = new StackWithMin();
        s.push(5);
        s.push(2);
        s.push(8);
        s.push(1);
        System.out.println("Minimum: " + s.getMin()); // 1
        s.pop();
        System.out.println("Minimum after pop: " + s.getMin()); // 2
    }
}
