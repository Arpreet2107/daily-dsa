// Node class for singly linked list
class Node {
    int data;
    Node next;

    // Constructor to initialize a node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Singly linked list implementation
public class InsertAtPosition {
    Node head;

    // Method to insert a node at a given position (1-based index)
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        // Case 1: Insert at the beginning (position 1)
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Traverse to the (position - 1)th node
        Node current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        // If position is invalid (larger than list size + 1)
        if (current == null) {
            System.out.println("Invalid position: " + position);
            return;
        }

        // Insert new node
        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to print the linked list
    public void printList() {
        Node temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method for testing
    public static void main(String[] args) {
        InsertAtPosition list = new InsertAtPosition();

        // Initial inserts
        list.insertAtPosition(10, 1);  // List: 10
        list.insertAtPosition(20, 2);  // List: 10 -> 20
        list.insertAtPosition(30, 3);  // List: 10 -> 20 -> 30
        list.insertAtPosition(15, 2);  // List: 10 -> 15 -> 20 -> 30
        list.insertAtPosition(5, 1);   // List: 5 -> 10 -> 15 -> 20 -> 30

        list.printList();
    }
}
