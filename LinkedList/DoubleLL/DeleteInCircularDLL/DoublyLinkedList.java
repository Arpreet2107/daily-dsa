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

    // Function to delete a node in a circular doubly linked list
    public static Node deleteInCircular(Node head, int data) {
        if (head == null) {
            return null;
        }

        Node temp = head;
        // Traverse the circular list
        do {
            if (temp.data == data) {
                // Case 1: Only one node in the list
                if (temp.next == temp) {
                    head = null;
                } else {
                    // Case 2: More than one node
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    if (temp == head) {
                        head = temp.next;  // Update the head if the node to be deleted is the head
                    }
                }
                break;
            }
            temp = temp.next;
        } while (temp != head);

        return head;
    }

    // Helper function to print the circular list (just to verify the deletion)
    public static void printList(Node head, int maxPrintCount) {
        Node temp = head;
        int count = 0;
        if (head != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
                count++;
            } while (temp != head && count < maxPrintCount);
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
        printList(head, 6); // Print a few nodes to verify circular list

        // Delete a node with data 2
        head = deleteInCircular(head, 2);

        System.out.println("Circular list after deletion of 2:");
        printList(head, 6); // Print the list after deletion
    }
}
