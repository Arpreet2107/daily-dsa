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

    // Rotate the Circular Linked List by K positions
    public void rotateList(int k) {
        if (head == null || k == 0) return;

        Node temp = head;
        int length = 1;

        // Find the length of the list
        while (temp.next != head) {
            temp = temp.next;
            length++;
        }

        k = k % length; // In case k is greater than length

        if (k == 0) return; // No rotation needed

        Node current = head;
        for (int i = 1; i < length - k; i++) {
            current = current.next;
        }

        Node newHead = current.next;
        current.next = head;

        Node lastNode = newHead;
        while (lastNode.next != head) {
            lastNode = lastNode.next;
        }

        lastNode.next = newHead;
        head = newHead;
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

        System.out.println("Original Circular Linked List:");
        list.displayList();

        list.rotateList(2);

        System.out.println("Circular Linked List after rotating by 2 positions:");
        list.displayList();
    }
}
