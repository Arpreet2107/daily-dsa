public class DLL {
    // Node class represents each element in the doubly linked list
    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;

    // Constructor
    public DLL() {
        this.head = null;
        this.tail = null;
    }

    // Insert a node at the end (for testing)
    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Display the list from head to tail
    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Iterative method to reverse the list
    public void reverseIterative() {
        Node current = head;
        Node temp = null;

        // Traverse through the list and reverse the next and prev pointers
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        // After the loop, the temp will be pointing to the previous node
        if (temp != null) {
            head = temp.prev;
        }
    }

    // Recursive method to reverse the list
    public void reverseRecursive() {
        reverseRecursiveHelper(head);
    }

    private void reverseRecursiveHelper(Node current) {
        // Base case: If the list is empty or only one node, return
        if (current == null) {
            return;
        }

        // Swap the next and prev pointers of the current node
        Node temp = current.prev;
        current.prev = current.next;
        current.next = temp;

        // If the current node's prev is null, we've reached the new head
        if (current.prev == null) {
            head = current;
            return;
        }

        // Recur for the next node (which is now the previous node due to swap)
        reverseRecursiveHelper(current.prev);
    }

    // Main method to test the doubly linked list with both reverse methods
    public static void main(String[] args) {
        DLL list = new DLL();

        // Inserting nodes
        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);
        list.insertLast(40);
        list.insertLast(50);

        // Display original list
        System.out.println("Original List:");
        list.displayForward();  // Output: 10 <-> 20 <-> 30 <-> 40 <-> 50 <-> null

        // Reversing the list iteratively
        list.reverseIterative();
        System.out.println("List after Iterative Reversal:");
        list.displayForward();  // Output: 50 <-> 40 <-> 30 <-> 20 <-> 10 <-> null

        // Reversing the list recursively
        list.reverseRecursive();
        System.out.println("List after Recursive Reversal:");
        list.displayForward();  // Output: 10 <-> 20 <-> 30 <-> 40 <-> 50 <-> null
    }
}
