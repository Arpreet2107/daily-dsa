// File: StackUsingQueuesPopCostly.java

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueuesPopCostly {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int x) {
        q1.add(x);
    }

    int pop() {
        if (q1.isEmpty()) throw new RuntimeException("Stack is Empty");

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int top = q1.remove();

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    int top() {
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int top = q1.peek();
        q2.add(q1.remove());

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    public static void main(String[] args) {
        StackUsingQueuesPopCostly s = new StackUsingQueuesPopCostly();
        s.push(5);
        s.push(10);
        System.out.println("Top: " + s.top()); // 10
        System.out.println("Pop: " + s.pop()); // 10
    }
}
