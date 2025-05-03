class CircularLinkedList {
    Node head;

    // Node class for Circular Linked List
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to add a node at the end
    public void addNode(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Circular reference
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Detect and remove loop
    public void detectAndRemoveLoop() {
        Node slow = head, fast = head;

        // Detect loop using Floyd's Cycle Detection Algorithm (Tortoise and Hare)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Loop detected, now remove it
                removeLoop(slow);
                return;
            }
        }

        System.out.println("No loop detected.");
    }

    private void removeLoop(Node loopNode) {
        Node ptr1 = head;
        Node ptr2 = loopNode;

        // Find the start of the loop
        while (ptr2.next != loopNode) {
            ptr2 = ptr2.next;
        }

        // Loop termination
        ptr2.next = null;
        System.out.println("Loop removed.");
    }

    // Method to display the list
    public void displayList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
        list.addNode(50);

        System.out.println("Circular Linked List with Loop:");
        list.displayList();

        // Creating a loop manually for testing
        list.head.next.next.next.next.next = list.head.next.next;

        // Detect and remove loop
        list.detectAndRemoveLoop();

        System.out.println("List after removing loop:");
        list.displayList();
    }
}
