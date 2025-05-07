// File: RedundantBrackets.java

import java.util.Stack;

public class RedundantBrackets {

    static boolean hasRedundantBrackets(String expr) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expr.toCharArray()) {
            if (ch == ')') {
                char top = stack.pop();
                boolean isRedundant = true;

                while (top != '(') {
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        isRedundant = false;
                    }
                    top = stack.pop();
                }

                if (isRedundant) return true;
            } else {
                stack.push(ch);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String expr1 = "((a+b))";
        String expr2 = "(a+(b*c))";

        System.out.println("Redundant in '" + expr1 + "'? " + hasRedundantBrackets(expr1));
        System.out.println("Redundant in '" + expr2 + "'? " + hasRedundantBrackets(expr2));
    }
}
