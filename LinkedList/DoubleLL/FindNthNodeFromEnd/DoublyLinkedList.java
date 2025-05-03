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

    // Function to find the nth node from the end
    public static Node findNthFromEnd(Node head, int n) {
        if (head == null) {
            return null;
        }

        Node fast = head;
        Node slow = head;

        // Move fast pointer n nodes ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return null;  // If n is greater than the length of the list
            }
            fast = fast.next;
        }

        // Move both fast and slow pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;  // Slow will now point to the nth node from the end
    }

    // Helper function to print the list (just to verify)
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
        // Create a doubly linked list: 1 <-> 2 <-> 3 <-> 4
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;

        System.out.println("Original list:");
        printList(head);

        // Find the 2nd node from the end
        Node nthNode = findNthFromEnd(head, 2);
        if (nthNode != null) {
            System.out.println("2nd node from the end: " + nthNode.data);
        } else {
            System.out.println("Node not found");
        }
    }
}
