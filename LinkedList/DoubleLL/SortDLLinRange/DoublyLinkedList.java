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

    // Function to remove nodes outside the specified range and sort the remaining nodes within the range
    public static Node sortWithinRange(Node head, int low, int high) {
        if (head == null) {
            return null;
        }

        Node current = head;

        // Remove nodes outside the specified range
        while (current != null) {
            if (current.data < low || current.data > high) {
                // Remove current node from the list
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    // If it's the head node, update head
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                current = current.next;
            } else {
                current = current.next;
            }
        }

        // Sorting logic here: insertion sort or any other sorting algorithm
        head = insertionSortDLL(head);

        return head;
    }

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
        // Create a doubly linked list: 1 <-> 4 <-> 6
        Node head = new Node(1);
        head.next = new Node(4);
        head.next.prev = head;
        head.next.next = new Node(6);
        head.next.next.prev = head.next;

        System.out.println("Original list:");
        printList(head);

        // Remove nodes outside the range [3, 5] and sort the remaining list
        head = sortWithinRange(head, 3, 5);

        System.out.println("List after removing nodes outside range [3, 5] and sorting:");
        printList(head);
    }
}
