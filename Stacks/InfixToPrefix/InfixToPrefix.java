// File: InfixToPrefix.java

import java.util.Stack;

public class InfixToPrefix {

    // Precedence of operators
    static int precedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    // Reverse expression and adjust brackets
    static String reverseAndReplace(String expr) {
        StringBuilder reversed = new StringBuilder(expr).reverse();
        for (int i = 0; i < reversed.length(); i++) {
            if (reversed.charAt(i) == '(') reversed.setCharAt(i, ')');
            else if (reversed.charAt(i) == ')') reversed.setCharAt(i, '(');
        }
        return reversed.toString();
    }

    // Convert to postfix (reused from postfix code)
    static String infixToPostfix(String expr) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : expr.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Final conversion to prefix
    static String infixToPrefix(String expr) {
        String reversed = reverseAndReplace(expr);
        String postfix = infixToPostfix(reversed);
        return new StringBuilder(postfix).reverse().toString();
    }

    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Prefix: " + infixToPrefix(infix));
    }
}
