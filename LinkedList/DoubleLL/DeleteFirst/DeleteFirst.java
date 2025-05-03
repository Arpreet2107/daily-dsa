public class DeleteFirst {

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

    public DeleteFirst() {
        this.head = null;
        this.tail = null;
    }

    // Delete the first node (from the beginning)
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }

        if (head == tail) {
            // Only one node in the list
            head = tail = null;
        } else {
            // Move the head pointer to the next node
            head = head.next;
            head.prev = null; // Set the previous pointer of the new head to null
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
        DeleteFirst list = new DeleteFirst();

        // Inserting nodes at the beginning
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);

        // Display the list
        System.out.println("Before Deleting from First:");
        list.displayForward();

        // Deleting the first node
        list.deleteFirst();

        // Display the list after deletion
        System.out.println("After Deleting from First:");
        list.displayForward();
    }

    // Helper method to insert at the beginning
    public void insertFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
}
