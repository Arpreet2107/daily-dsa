class CircularLinkedList {
    Node head;
    Node tail;

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to detect a loop in the circular linked list
    public boolean hasLoop() {
        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Loop detected
            }
        }

        return false; // No loop
    }

    // Method to add a node to the list
    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // Circular reference
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Circular reference
        }
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);

        // Test with a loop (manual manipulation for testing purposes)
        list.tail.next = list.head; // Create a loop

        System.out.println("Does the list have a loop? " + list.hasLoop());
    }
}
