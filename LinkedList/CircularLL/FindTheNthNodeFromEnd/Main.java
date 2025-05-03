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

    // Method to find the nth node from the end
    public Node findNthFromEnd(int n) {
        if (head == null) {
            return null;
        }

        Node first = head;
        Node second = head;

        // Move the first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (first.next == head) {
                return null; // List is shorter than n nodes
            }
            first = first.next;
        }

        // Move both pointers until first pointer reaches the last node
        while (first.next != head) {
            first = first.next;
            second = second.next;
        }

        return second;
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

        Node nthNode = list.findNthFromEnd(3);
        if (nthNode != null) {
            System.out.println("3rd node from the end is: " + nthNode.data);
        } else {
            System.out.println("Node not found.");
        }
    }
}
