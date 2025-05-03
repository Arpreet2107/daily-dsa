public class InsertFirst {

    // Node class represents each element in the doubly linked list
    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;

    // Constructor
    public InsertFirst() {
        this.head = null;
        this.tail = null;
    }

    // Insert a node at the beginning (Insert First)
    public void insertFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;  // Head and Tail both point to the new node when list is empty
            return;
        }

        newNode.next = head;  // New node's next points to the old head
        head.prev = newNode;  // Old head's prev points to the new node
        head = newNode;       // Update head to point to the new node
    }

    // Display the list from head to tail
    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test the doubly linked list with insertFirst
    public static void main(String[] args) {
        InsertFirst list = new InsertFirst();

        // Inserting nodes at the beginning
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);

        // Display the list
        System.out.println("After Inserting at the Beginning:");
        list.displayForward();  // Output: 30 <-> 20 <-> 10 <-> null
    }
}
