public class DeleteAtPosition {

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

    public DeleteAtPosition() {
        this.head = null;
        this.tail = null;
    }

    // Delete a node at a given position
    public void deleteAtPosition(int position) {
        // If the list is empty, do nothing
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        // If the position is 0, delete the first node
        if (position == 0) {
            deleteFirst();
            return;
        }

        Node current = head;
        int currentPosition = 0;

        // Traverse the list to find the node at the given position
        while (current != null && currentPosition < position) {
            current = current.next;
            currentPosition++;
        }

        // If the position is beyond the list size, do nothing
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        // If the node to be deleted is the last node
        if (current.next == null) {
            deleteLast();
            return;
        }

        // Adjust the pointers to remove the node from the list
        current.prev.next = current.next;
        current.next.prev = current.prev;

        current = null;  // Optional: Clear reference to the node
    }

    // Delete the first node
    public void deleteFirst() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        // If there's only one node
        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    // Delete the last node
    public void deleteLast() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        // If there's only one node
        if (head == tail) {
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
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

    // Main method to test delete at position functionality
    public static void main(String[] args) {
        DeleteAtPosition list = new DeleteAtPosition();

        // Inserting nodes at the beginning and end to test deletion
        list.insertFirst(10);  // List: 10
        list.insertLast(20);   // List: 10 <-> 20
        list.insertLast(30);   // List: 10 <-> 20 <-> 30
        list.insertLast(40);   // List: 10 <-> 20 <-> 30 <-> 40
        list.insertLast(50);   // List: 10 <-> 20 <-> 30 <-> 40 <-> 50

        System.out.println("Original List:");
        list.displayForward();  // Expected Output: 10 <-> 20 <-> 30 <-> 40 <-> 50 <-> null

        // Deleting a node at a given position
        list.deleteAtPosition(2);  // Delete node at position 2 (value 30)
        System.out.println("After Deleting at Position 2:");
        list.displayForward();  // Expected Output: 10 <-> 20 <-> 40 <-> 50 <-> null

        list.deleteAtPosition(0);  // Delete node at position 0 (value 10)
        System.out.println("After Deleting at Position 0:");
        list.displayForward();  // Expected Output: 20 <-> 40 <-> 50 <-> null

        list.deleteAtPosition(1);  // Delete node at position 1 (value 40)
        System.out.println("After Deleting at Position 1:");
        list.displayForward();  // Expected Output: 20 <-> 50 <-> null

        // Trying to delete a position out of bounds
        list.deleteAtPosition(10);  // Position out of bounds
    }

    // Helper Methods for Insert (for testing purposes)
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
}
