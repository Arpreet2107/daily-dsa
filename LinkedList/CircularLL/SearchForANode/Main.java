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

    // Method to search for a node with a specific value
    public boolean searchNode(int value) {
        Node temp = head;

        if (head == null) {
            return false;
        }

        do {
            if (temp.data == value) {
                return true;  // Node found
            }
            temp = temp.next;
        } while (temp != head);

        return false;  // Node not found
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
            tail.next = head; // Maintain the circular structure
        }
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.addNode(10);
        cll.addNode(20);
        cll.addNode(30);

        System.out.println("Is 20 present? " + cll.searchNode(20));
        System.out.println("Is 50 present? " + cll.searchNode(50));
    }
}
