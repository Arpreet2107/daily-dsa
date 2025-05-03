class CircularBuffer {
    Node head, tail;
    int size, capacity;

    // Node class for circular buffer
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor to initialize circular buffer with capacity
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = this.tail = null;
    }

    // Method to insert data into the buffer
    public void insert(int data) {
        if (size == capacity) {
            System.out.println("Buffer is full. Overwriting the oldest data.");
            delete(); // Remove the oldest data (head)
        }

        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head; // Circular link
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Circular link
        }
        size++;
    }

    // Method to remove the oldest data from the buffer (head node)
    public void delete() {
        if (head == null) {
            System.out.println("Buffer is empty.");
            return;
        }

        if (head == tail) {
            head = tail = null; // Only one element in the buffer
        } else {
            head = head.next; // Move head to the next node
            tail.next = head; // Maintain circular link
        }
        size--;
    }

    // Method to display the circular buffer content
    public void display() {
        if (head == null) {
            System.out.println("Buffer is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(5);
        buffer.insert(10);
        buffer.insert(20);
        buffer.insert(30);
        buffer.insert(40);
        buffer.insert(50);
        buffer.display(); // Output: 10 20 30 40 50

        buffer.insert(60); // Overwrites 10
        buffer.display(); // Output: 20 30 40 50 60

        buffer.delete(); // Removes 20
        buffer.display(); // Output: 30 40 50 60
    }
}
