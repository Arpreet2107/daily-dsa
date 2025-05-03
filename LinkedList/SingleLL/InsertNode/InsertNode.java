// Node class to represent each node in the list
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Class to manage the singly linked list
public class InsertNode {
    Node head;

    // Method to insert a node at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head; // Point the new node to the current head
        head = newNode; // Update the head to the new node
    }

    // Method to insert a node at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next; // Traverse to the last node
        }
        current.next = newNode; // Make the last node point to the new node
    }

    // Method to insert a node at a specific position in the list
    public void insertAtPosition(int data, int position) {
        // If position is 0, insert at the beginning
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;

        // Traverse to the node just before the desired position
        for (int i = 0; current != null && i < position - 1; i++) {
            current = current.next;
        }

        // If the position is greater than the number of nodes, insert at the end
        if (current == null) {
            insertAtEnd(data);
            return;
        }

        // Adjust the pointers to insert the new node
        newNode.next = current.next;
        current.next = newNode;
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

    // Main method to test node insertion
    public static void main(String[] args) {
        InsertNode list = new InsertNode();

        // Insert nodes at the beginning
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtBeginning(30);
        list.printList(); // Output: 30 -> 20 -> 10 -> null

        // Insert nodes at the end
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.printList(); // Output: 30 -> 20 -> 10 -> 40 -> 50 -> null

        // Insert node at a specific position (position 2)
        list.insertAtPosition(25, 2);
        list.printList(); // Output: 30 -> 20 -> 25 -> 10 -> 40 -> 50 -> null

        // Insert node at an invalid position (greater than the list size)
        list.insertAtPosition(60, 10);
        list.printList(); // Output: 30 -> 20 -> 25 -> 10 -> 40 -> 50 -> 60 -> null
    }
}
