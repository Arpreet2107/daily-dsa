// File: EvaluatePostfix.java

import java.util.Stack;

public class EvaluatePostfix {
    public static int evaluate(String expr) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : expr.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');  // Convert char to int and push
            } else {
                int b = stack.pop();  // Second operand
                int a = stack.pop();  // First operand

                // Apply operation
                stack.push(switch (ch) {
                    case '+' -> a + b;
                    case '-' -> a - b;
                    case '*' -> a * b;
                    case '/' -> a / b;
                    default -> throw new IllegalArgumentException("Invalid operator: " + ch);
                });
            }
        }

        return stack.pop();  // Final result
    }

    public static void main(String[] args) {
        String postfix = "231*+9-";  // Equivalent to: 2 + (3 * 1) - 9 = -4
        int result = evaluate(postfix);
        System.out.println("Result: " + result);
    }
}
