// Node class represents each element in the singly linked list
class Node {
    int data;        // Value of the node
    Node next;       // Reference to the next node

    // Constructor to initialize node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// SingleLinkedList class handles operations on the list
public class SLL {
    Node head; // Head points to the first node in the list

    // Method to insert node at the end
    public void insert(int data) {
        Node newNode = new Node(data); // Create a new node

        if (head == null) {
            head = newNode; // If list is empty, set head to new node
        } else {
            Node current = head;
            // Traverse to the end of the list
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; // Link new node at the end
        }
    }

    // Method to print all elements of the list
    public void printList() {
        Node current = head;

        // Check if the list is empty
        if (current == null) {
            System.out.println("The list is empty.");
            return;
        }

        // Traverse through the list and print each node's data
        System.out.print("Linked List Elements: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null"); // End of list
    }

    // Main method to test linked list
    public static void main(String[] args) {
        // Create a new list
        SLL list = new SLL();

        // Insert elements into the list
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        // Print the linked list
        list.printList();
    }
}
