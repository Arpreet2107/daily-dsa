class CircularDoublyLinkedList {
    Node head;

    // Node class for Circular Doubly Linked List
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = this;
            this.prev = this;
        }
    }

    // Method to add a node at the end
    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode; // First node
        } else {
            Node tail = head.prev; // Last node (prev of head)
            tail.next = newNode; // Previous tail's next points to new node
            newNode.prev = tail; // New node's previous points to tail
            newNode.next = head; // New node's next points to head
            head.prev = newNode; // Head's previous points to new node (making it circular)
        }
    }

    // Method to display the list
    public void displayList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    // Method to delete a node
    public void deleteNode(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            if (temp.data == value) {
                if (temp == head && temp.next == head) {
                    head = null; // Single node case
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    if (temp == head) {
                        head = temp.next; // Move head if it's the first node
                    }
                }
                System.out.println("Node " + value + " deleted.");
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Node " + value + " not found.");
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);

        System.out.println("Circular Doubly Linked List:");
        list.displayList();

        list.deleteNode(30);
        list.displayList();
    }
}
