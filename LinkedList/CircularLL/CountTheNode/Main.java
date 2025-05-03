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
        tail.next = head; // Maintain the circular structure
    }
}

    // Method to count the nodes in the list
    public int countNodes() {
        if (head == null) {
            return 0;
        }

        int count = 1;
        Node temp = head;
        while (temp.next != head) {
            count++;
            temp = temp.next;
        }
        return count;
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
        CircularLinkedList cll = new CircularLinkedList();
        cll.addNode(10);
        cll.addNode(20);
        cll.addNode(30);

        System.out.println("Number of nodes: " + cll.countNodes());
    }
}
