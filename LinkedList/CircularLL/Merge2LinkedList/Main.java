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

    // Method to print the list in reverse order
    public void printReverse(Node node) {
        if (node == null || (node.next == head)) {
            return;  // Base case to stop recursion
        }
        printReverse(node.next);
        System.out.print(node.data + " <- ");
    }

    // Method to display the list in reverse order
    public void displayReverse() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        printReverse(head);
        System.out.println("(back to head)");
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

    // Method to add a node to the circular linked list
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // Point to itself to form a circular structure
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain circular structure
        }
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.addNode(10);
        cll.addNode(20);
        cll.addNode(30);
        cll.addNode(40);

        System.out.println("List in reverse order:");
        cll.displayReverse();
    }
}
