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

    // Function to clone a doubly linked list
    public static Node cloneDLL(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a copy of each node and insert it after the original node
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.data);
            newNode.next = current.next;
            current.next = newNode;
            newNode.prev = current;
            current = newNode.next;
        }

        // Step 2: Fix the prev pointers for the new nodes
        current = head;
        while (current != null) {
            if (current.next != null) {
                current.next.prev = current;
            }
            current = current.next;
        }

        // Step 3: Separate the original list and the cloned list
        Node newHead = head.next;
        Node original = head;
        Node copy = newHead;

        while (original != null) {
            original.next = copy.next;
            if (copy.next != null) {
                copy.next.prev = original;
            }
            original = original.next;
            if (copy.next != null) {
                copy = copy.next;
            }
        }

        return newHead;
    }

    // Helper function to print the list (just to verify the cloning)
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
        // Create a doubly linked list: 1 <-> 2 <-> 3
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;

        System.out.println("Original list:");
        printList(head);

        // Clone the list
        Node clonedHead = cloneDLL(head);

        System.out.println("Cloned list:");
        printList(clonedHead);
    }
}
