public class ArrayStack {
    private final int maxSize;
    private int top;
    private final int[] stack;

    // Constructor to initialize stack
    public ArrayStack(int size) {
        maxSize = size;
        stack = new int[maxSize];  // Create array for stack
        top = -1;  // Stack is initially empty
    }

    // Push operation
    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow");  // No space to push
        } else {
            stack[++top] = value;  // Increment top and insert value
            System.out.println(value + " pushed to stack");
        }
    }

    // Pop operation
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");  // Stack is empty
            return -1;
        }
        return stack[top--];  // Return top element and decrement top
    }

    // Peek operation
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];  // Return the top element without removing it
    }

    // Main method to test
    public static void main(String[] args) {
        ArrayStack s = new ArrayStack(5);
        s.push(10);
        s.push(20);
        System.out.println("Top element is: " + s.peek());
        System.out.println("Popped: " + s.pop());
        System.out.println("Top after pop: " + s.peek());
    }
}
