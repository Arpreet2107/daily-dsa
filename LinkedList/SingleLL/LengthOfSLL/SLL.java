// Node class: Represents each node in the linked list
class Node {
    int data;        // The data value of the node
    Node next;       // Pointer to the next node

    // Constructor to initialize a node with data
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// SingleLinkedList class: Implements the linked list operations
public class SLL {
    Node head; // Head points to the first node of the list

    // Method to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode; // First node becomes the head
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; // Traverse to the end
            }
            current.next = newNode; // Add the new node at the end
        }
    }

    // Method to find the length of the linked list
    public int getLength() {
        int count = 0;
        Node current = head;

        // Traverse the list and count nodes
        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    // Method to print the linked list
    public void printList() {
        Node current = head;

        // Traverse the list and print each node's data
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        SLL list = new SLL();

        // Insert elements
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        // Print the linked list
        System.out.print("Linked List: ");
        list.printList();

        // Print the length of the linked list
        System.out.println("Length of the Linked List: " + list.getLength());
    }
}
