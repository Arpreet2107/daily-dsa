// File: StackUsingQueuesPushCostly.java

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueuesPushCostly {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int x) {
        q2.add(x); // Always enqueue to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove()); // Push everything to q2
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp; // Swap q1 and q2
    }

    int pop() {
        if (q1.isEmpty()) throw new RuntimeException("Stack is Empty");
        return q1.remove();
    }

    int top() {
        return q1.peek();
    }

    public static void main(String[] args) {
        StackUsingQueuesPushCostly s = new StackUsingQueuesPushCostly();
        s.push(10);
        s.push(20);
        System.out.println("Top: " + s.top()); // 20
        System.out.println("Pop: " + s.pop()); // 20
    }
}
