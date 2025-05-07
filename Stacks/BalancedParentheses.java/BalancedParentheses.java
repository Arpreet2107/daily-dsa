// File: BalancedParentheses.java

import java.util.Stack;

public class BalancedParentheses {
    public static boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expr.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);  // Push opening brackets
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;  // No matching opening
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;  // Mismatched pair
                }
            }
        }

        return stack.isEmpty();  // Should be empty if balanced
    }

    public static void main(String[] args) {
        String expression = "{[()]}";
        System.out.println("Is balanced? " + isBalanced(expression));
    }
}
