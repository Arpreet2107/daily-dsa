// Node class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Class with insertion at end
public class InsertAtEnd {
    Node head;

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode; // List is empty
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode; // Link last node to new node
    }

    // Print the linked list
    public void printList() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        InsertAtEnd list = new InsertAtEnd();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        // Output: 10 -> 20 -> 30 -> null
        list.printList();
    }
}
