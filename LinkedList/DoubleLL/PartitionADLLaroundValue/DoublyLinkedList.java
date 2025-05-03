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

    // Function to partition the doubly linked list around a given value
    public static Node partition(Node head, int value) {
        if (head == null) {
            return null;
        }

        // Create two dummy heads for the smaller and larger lists
        Node smallerHead = new Node(0);
        Node largerHead = new Node(0);
        Node smaller = smallerHead;
        Node larger = largerHead;
        Node current = head;

        while (current != null) {
            if (current.data < value) {
                smaller.next = current;
                current.prev = smaller;
                smaller = smaller.next;
            } else {
                larger.next = current;
                current.prev = larger;
                larger = larger.next;
            }
            current = current.next;
        }

        // Connect the two lists
        smaller.next = largerHead.next;
        if (largerHead.next != null) {
            largerHead.next.prev = smaller;
        }
        larger.next = null;  // Ensure the last node of the larger list points to null

        return smallerHead.next;  // Return the start of the partitioned list
    }

    // Helper function to print the list (just to verify the partitioning)
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
        // Create a doubly linked list: 3 <-> 5 <-> 8 <-> 5 <-> 10
        Node head = new Node(3);
        head.next = new Node(5);
        head.next.prev = head;
        head.next.next = new Node(8);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(5);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.prev = head.next.next.next;

        System.out.println("Original list:");
        printList(head);

        // Partition the list around the value 5
        head = partition(head, 5);

        System.out.println("Partitioned list:");
        printList(head);
    }
}
