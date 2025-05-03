public class InsertAtPosition {

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

    public InsertAtPosition() {
        this.head = null;
        this.tail = null;
    }

    // Insert a node at a given position
    public void insertAtPosition(int data, int position) {
        // If the position is 0, insert at the beginning
        if (position == 0) {
            insertFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        int currentPosition = 0;

        // Traverse the list to find the position
        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        // If the position is beyond the end of the list, insert at the end
        if (current == null) {
            insertLast(data);
            return;
        }

        // Insert the new node in between the nodes
        newNode.next = current.next;
        newNode.prev = current;
        
        // If the node is not the last node, adjust the next node's prev pointer
        if (current.next != null) {
            current.next.prev = newNode;
        }

        current.next = newNode;
    }

    // Insert a node at the beginning (Insert First)
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert a node at the end (Insert Last)
    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
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

    public static void main(String[] args) {
        InsertAtPosition list = new InsertAtPosition();

        // Inserting nodes at different positions
        list.insertFirst(10);    // 10
        list.insertLast(30);     // 10 <-> 30
        list.insertAtPosition(20, 1); // Insert 20 at position 1: 10 <-> 20 <-> 30
        list.insertAtPosition(5, 0);  // Insert 5 at position 0: 5 <-> 10 <-> 20 <-> 30
        list.insertAtPosition(25, 3); // Insert 25 at position 3: 5 <-> 10 <-> 20 <-> 25 <-> 30

        // Display the list
        System.out.println("After Inserting at Different Positions:");
        list.displayForward();  // Expected Output: 5 <-> 10 <-> 20 <-> 25 <-> 30 <-> null
    }
}
