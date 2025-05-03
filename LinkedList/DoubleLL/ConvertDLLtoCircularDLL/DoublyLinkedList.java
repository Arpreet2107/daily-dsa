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

    // Function to convert the list to a circular doubly linked list
    public static Node convertToCircular(Node head) {
        if (head == null) {
            return null;
        }

        Node tail = head;
        // Traverse to the last node
        while (tail.next != null) {
            tail = tail.next;
        }

        // Connect the last node to the head to make it circular
        tail.next = head;
        head.prev = tail;

        return head;
    }

    // Helper function to print the circular list (just to verify the conversion)
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
        // Create a doubly linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;

        System.out.println("Original list:");
        printList(head, 3); // Just print a few nodes to verify the list

        // Convert the list to circular
        head = convertToCircular(head);

        System.out.println("Circular list:");
        printList(head, 6); // Print a few more nodes to verify the circularity
    }
}
