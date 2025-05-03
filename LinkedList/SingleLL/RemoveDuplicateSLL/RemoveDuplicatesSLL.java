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
public class RemoveDuplicatesSLL {
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

    // Method to remove duplicates from the sorted linked list
    public void removeDuplicates() {
        if (head == null) {
            return;
        }

        Node current = head;

        // Traverse the list and remove duplicates
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next; // Skip the duplicate node
            } else {
                current = current.next; // Move to the next node
            }
        }
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

    // Main method to test removing duplicates from a sorted list
    public static void main(String[] args) {
        RemoveDuplicatesSLL list = new RemoveDuplicatesSLL();

        // Insert some nodes to the list with duplicates
        list.insertAtEnd(10);
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(40);
        list.insertAtEnd(50);

        list.printList(); // Output: 10 -> 10 -> 20 -> 30 -> 30 -> 40 -> 40 -> 50 -> null

        // Remove duplicates
        list.removeDuplicates();

        list.printList(); // Output: 10 -> 20 -> 30 -> 40 -> 50 -> null
    }
}
