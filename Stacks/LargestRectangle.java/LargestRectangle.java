// File: LargestRectangle.java

import java.util.Stack;

public class LargestRectangle {

    // Function to calculate largest rectangle area in histogram
    static int getMaxArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        int i = 0;
        while (i < n) {
            // Push index if current bar is higher than stack top
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                // Pop the top and calculate area with popped height
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = heights[top] * width;
                maxArea = Math.max(maxArea, area);
            }
        }

        // Process remaining bars
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            int area = heights[top] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("Maximum Area: " + getMaxArea(heights));
    }
}
