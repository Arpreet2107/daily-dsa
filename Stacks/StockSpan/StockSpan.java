// File: StockSpan.java

import java.util.Stack;

public class StockSpan {

    // Function to calculate span values
    static void calculateSpan(int[] prices, int n, int[] span) {
        Stack<Integer> stack = new Stack<>(); // stores indices

        stack.push(0);
        span[0] = 1; // span of first day is always 1

        for (int i = 1; i < n; i++) {
            // Pop elements from stack while stack is not empty and price at top of stack <= current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, price[i] is greater than all to the left
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            stack.push(i); // push this index onto stack
        }
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int n = prices.length;
        int[] span = new int[n];

        calculateSpan(prices, n, span);

        System.out.println("Stock Spans:");
        for (int value : span) {
            System.out.print(value + " ");
        }
    }
}
