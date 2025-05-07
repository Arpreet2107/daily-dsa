class Node {
    int data;
    Node next;

    // Constructor for node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListStack {
    private Node top;  // Top of stack (linked list)

    // Constructor
    public LinkedListStack() {
        this.top = null;  // Initially empty
    }

    // Push operation
    public void push(int value) {
        Node newNode = new Node(value);  // Create new node
        newNode.next = top;  // Point new node to current top
        top = newNode;       // Update top to new node
        System.out.println(value + " pushed to stack");
    }

    // Pop operation
    public int pop() {
        if (top == null) {
            System.out.println("Stack Underflow");  // Empty stack
            return -1;
        }
        int popped = top.data;  // Save data to return
        top = top.next;         // Move top to next node
        return popped;
    }

    // Peek operation
    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;  // Return top value without removing
    }

    // Main method
    public static void main(String[] args) {
        LinkedListStack s = new LinkedListStack();
        s.push(100);
        s.push(200);
        System.out.println("Top element is: " + s.peek());
        System.out.println("Popped: " + s.pop());
        System.out.println("Top after pop: " + s.peek());
    }
}
