// Node class representing each element of the list
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Class to manage the singly linked list
public class DeleteLastNode {
    Node head; // Head of the list

    // Method to insert a new node at the end
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

    // Method to delete the last node
    public void deleteLastNode() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        // If there's only one node
        if (head.next == null) {
            head = null;
            return;
        }

        // Traverse to second last node
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        // Remove reference to last node
        current.next = null;
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

    // Main method to test the code
    public static void main(String[] args) {
        DeleteLastNode list = new DeleteLastNode();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        System.out.println("Original list:");
        list.printList(); // Output: 10 -> 20 -> 30 -> null

        list.deleteLastNode(); // Deletes 30
        System.out.println("After deleting last node:");
        list.printList(); // Output: 10 -> 20 -> null

        list.deleteLastNode(); // Deletes 20
        list.deleteLastNode(); // Deletes 10
        list.deleteLastNode(); // Tries to delete from empty list
    }
}
