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

    // Function to perform insertion sort on a doubly linked list
    public static Node insertionSortDLL(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head.next;
        while (current != null) {
            int keyValue = current.data;
            Node key = current;
            Node keyPrev = key.prev;

            // Move the key node to its correct position in the sorted part of the list
            while (keyPrev != null && keyValue < keyPrev.data) {
                key.data = keyPrev.data;
                key = keyPrev;
                keyPrev = key.prev;
            }
            key.data = keyValue;
            current = current.next;
        }

        return head;
    }

    // Helper function to print the list (just to verify the sorting)
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        // Create a doubly linked list: 4 <-> 3 <-> 5
        Node head = new Node(4);
        head.next = new Node(3);
        head.next.prev = head;
        head.next.next = new Node(5);
        head.next.next.prev = head.next;

        System.out.println("Original list:");
        printList(head);

        // Perform insertion sort
        head = insertionSortDLL(head);

        System.out.println("Sorted list:");
        printList(head);
    }
}
