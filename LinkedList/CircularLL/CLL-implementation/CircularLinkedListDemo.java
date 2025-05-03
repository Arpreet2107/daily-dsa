// Circular Linked List implementation
class CircularLinkedList {
    Node head;
    Node tail;

    // Node class for circular linked list
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to add a node at the end
    public void addNode(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // points to itself for circularity
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // maintains circular link
        }
    }

    // Method to display the Circular Linked List
    public void displayList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head); // loop back to head for circularity
        System.out.println("(back to head)");
    }

    // Method to delete a node by value
    public void deleteNode(int value) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        Node temp = head;
        Node prev = null;

        // If head node itself holds the value to be deleted
        if (temp != null && temp.data == value) {
            if (head == tail) { // Only one node in the list
                head = null;
                tail = null;
            } else {
                tail.next = temp.next; // tail now points to the next of head
                head = temp.next; // move head to next node
            }
            System.out.println("Node with value " + value + " deleted.");
            return;
        }

        // Search for the node to be deleted
        do {
            prev = temp;
            temp = temp.next;
            if (temp.data == value) {
                prev.next = temp.next;
                if (temp == tail) {
                    tail = prev; // update tail if we delete the last node
                }
                System.out.println("Node with value " + value + " deleted.");
                return;
            }
        } while (temp != head); // loop back to head if the node is not found

        System.out.println("Node with value " + value + " not found.");
    }
}

// Main class
public class CircularLinkedListDemo {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        // Adding nodes
        cll.addNode(10);
        cll.addNode(20);
        cll.addNode(30);
        cll.addNode(40);

        // Display the Circular Linked List
        System.out.println("Circular Linked List:");
        cll.displayList();

        // Deleting a node
        cll.deleteNode(20);
        cll.displayList();

        // Deleting another node
        cll.deleteNode(10);
        cll.displayList();

        // Try deleting a node that doesn't exist
        cll.deleteNode(100);
    }
}
