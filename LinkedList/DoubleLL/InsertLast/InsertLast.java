public class InsertLast {

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
    public InsertLast() {
        this.head = null;
        this.tail = null;
    }

    // Insert a node at the end (Insert Last)
    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;  // Head and Tail both point to the new node when list is empty
            return;
        }

        tail.next = newNode;  // Old tail's next points to the new node
        newNode.prev = tail;  // New node's prev points to the old tail
        tail = newNode;       // Update tail to the new node
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

    // Main method to test the doubly linked list with insertLast
    public static void main(String[] args) {
        InsertLast list = new InsertLast();

        // Inserting nodes at the end
        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);

        // Display the list
        System.out.println("After Inserting at the End:");
        list.displayForward();  // Output: 10 <-> 20 <-> 30 <-> null
    }
}
