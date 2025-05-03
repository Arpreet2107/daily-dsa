public class DoublyLinkedListDeleteLast {

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

    public DoublyLinkedListDeleteLast() {
        this.head = null;
        this.tail = null;
    }

    // Delete the last node (from the end)
    public void deleteLast() {
        if (tail == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }

        if (head == tail) {
            // Only one node in the list
            head = tail = null;
        } else {
            // Move the tail pointer to the previous node
            tail = tail.prev;
            tail.next = null; // Set the next pointer of the new tail to null
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
        DoublyLinkedListDeleteLast list = new DoublyLinkedListDeleteLast();

        // Inserting nodes at the end
        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);

        // Display the list
        System.out.println("Before Deleting from Last:");
        list.displayForward();

        // Deleting the last node
        list.deleteLast();

        // Display the list after deletion
        System.out.println("After Deleting from Last:");
        list.displayForward();
    }

    // Helper method to insert at the end
    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
}
