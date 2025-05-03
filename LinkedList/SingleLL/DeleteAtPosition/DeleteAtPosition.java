// Node class to define structure of each node
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Class to manage the Singly Linked List
public class DeleteAtPosition {
    Node head;

    // Method to insert node at the end (for testing)
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

    // Method to delete a node at a given position (1-based index)
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Deleting first node
        if (position == 1) {
            head = head.next;
            return;
        }

        // Traverse to the (position - 1)th node
        Node current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        // If position is invalid or beyond the length
        if (current == null || current.next == null) {
            System.out.println("Invalid position: " + position);
            return;
        }

        // Skip the node at 'position'
        current.next = current.next.next;
    }

    // Method to print the linked list
    public void printList() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test deletion at position
    public static void main(String[] args) {
        DeleteAtPosition list = new DeleteAtPosition();

        // Insert test data
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        System.out.println("Original list:");
        list.printList(); // 10 -> 20 -> 30 -> 40 -> null

        list.deleteAtPosition(2); // Deletes 20
        System.out.println("After deleting node at position 2:");
        list.printList(); // 10 -> 30 -> 40 -> null

        list.deleteAtPosition(1); // Deletes 10
        System.out.println("After deleting node at position 1:");
        list.printList(); // 30 -> 40 -> null

        list.deleteAtPosition(5); // Invalid position
    }
}
