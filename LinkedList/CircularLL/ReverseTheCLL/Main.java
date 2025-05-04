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

    // Method to reverse the circular linked list
    public void reverse() {
        if (head == null || head.next == head) {
            return; // Nothing to reverse
        }

        Node prev = null;
        Node current = head;
        Node nextNode = null;

        do {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        } while (current != head);

        head.next = prev; // Connect the last node to the head
        head = prev; // Update the head to the new first node
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
        list.addNode(40);

        System.out.println("Original List:");
        list.displayList();

        list.reverse();
        System.out.println("Reversed List:");
        list.displayList();
    }
}
