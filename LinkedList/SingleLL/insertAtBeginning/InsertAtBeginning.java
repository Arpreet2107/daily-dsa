// Node class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Class with insertion at beginning
public class InsertAtBeginning {
    Node head;

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;  // Point to old head
        head = newNode;       // New node becomes the new head
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
        InsertAtBeginning list = new InsertAtBeginning();

        list.insertAtBeginning(30);
        list.insertAtBeginning(20);
        list.insertAtBeginning(10);

        // Output: 10 -> 20 -> 30 -> null
        list.printList();
    }
}
