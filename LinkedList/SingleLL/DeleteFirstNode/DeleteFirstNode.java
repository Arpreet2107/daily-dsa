// Node class to represent each element in the list
class Node {
    int data;
    Node next;

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Class to handle singly linked list operations
public class DeleteFirstNode {
    Node head; // head of the list

    // Method to add elements at the end (for testing purposes)
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Method to delete the first node
    public void deleteFirstNode() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        // Just move head to the next node
        head = head.next;
    }

    // Method to display the linked list
    public void printList() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test functionality
    public static void main(String[] args) {
        DeleteFirstNode list = new DeleteFirstNode();

        // Adding nodes to the list
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        System.out.println("Original list:");
        list.printList(); // Output: 10 -> 20 -> 30 -> null

        // Delete first node
        list.deleteFirstNode();

        System.out.println("After deleting the first node:");
        list.printList(); // Output: 20 -> 30 -> null
    }
}
