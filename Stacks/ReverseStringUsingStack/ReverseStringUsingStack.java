// File: ReverseStringUsingStack.java

import java.util.Stack;

public class ReverseStringUsingStack {
    public static String reverse(String input) {
        Stack<Character> stack = new Stack<>();

        // Push all characters onto the stack
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        // Pop all characters to build the reversed string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        String original = "hello";
        String reversed = reverse(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}
