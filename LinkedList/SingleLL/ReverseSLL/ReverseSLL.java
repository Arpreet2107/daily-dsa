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
public class ReverseSLL {
    Node head;

    // Method to insert a node at the end of the list
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

    // Method to reverse the linked list
    public void reverseList() {
        Node prev = null;
        Node current = head;
        Node next;

        // Traverse the list and reverse the pointers
        while (current != null) {
            next = current.next;  // Save the next node
            current.next = prev;  // Reverse the current node's pointer
            prev = current;       // Move prev to current
            current = next;       // Move current to next
        }

        head = prev;  // Set the head to the last node
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

    // Main method to test the reverse functionality
    public static void main(String[] args) {
        ReverseSLL list = new ReverseSLL();

        // Insert some nodes to the list
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        System.out.println("Original list:");
        list.printList();  // Output: 10 -> 20 -> 30 -> 40 -> null

        // Reverse the list
        list.reverseList();

        System.out.println("Reversed list:");
        list.printList();  // Output: 40 -> 30 -> 20 -> 10 -> null
    }
}
