class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {

    // Function to insert a new node in a circular doubly linked list
    public static Node insertInCircular(Node head, int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            // If the list is empty, create a new circular list
            newNode.next = newNode;
            newNode.prev = newNode;
            return newNode;
        }

        // Find the tail (the node before the head)
        Node tail = head.prev;
        
        // Insert the new node
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;

        return head;
    }

    // Helper function to print the circular list (just to verify the insertion)
    public static void printList(Node head, int maxPrintCount) {
        Node temp = head;
        int count = 0;
        while (temp != null && count < maxPrintCount) {
            System.out.print(temp.data + " ");
            temp = temp.next;
            count++;
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        // Create a circular doubly linked list with nodes 1, 2, 3
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.prev = head.next.next;
        head.next.next.next = head; // Making the list circular

        System.out.println("Original circular list:");
        printList(head, 6);  // Print a few nodes to verify circular list

        // Insert a new node with data 4 into the circular list
        head = insertInCircular(head, 4);

        System.out.println("Circular list after insertion of 4:");
        printList(head, 6);  // Print a few nodes to verify the insertion
    }
}
