// File: CheckStackStatus.java

public class CheckStackStatus {
    private final int[] stack;
    private int top;
    private final int maxSize;

    // Constructor
    public CheckStackStatus(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    // Push method
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is FULL. Cannot push " + value);
            return;
        }
        stack[++top] = value;
        System.out.println(value + " pushed");
    }

    // Check if stack is full
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        CheckStackStatus s = new CheckStackStatus(3);
        System.out.println("Is stack empty? " + s.isEmpty());
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println("Is stack full? " + s.isFull());
    }
}
