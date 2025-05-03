class CircularLinkedListUnique {
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

    // Method to insert after a given node
    public void insertAfter(int target, int data) {
        Node newNode = new Node(data);
        Node temp = head;

        do {
            if (temp.data == target) {
                newNode.next = temp.next;
                temp.next = newNode;
                if (temp == tail) {  // update tail if the node was the last one
                    tail = newNode;
                }
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Node with value " + target + " not found.");
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
        CircularLinkedListUnique cll = new CircularLinkedListUnique();
        cll.addNode(10);
        cll.addNode(20);
        cll.addNode(30);

        cll.insertAfter(20, 25);
        cll.displayList();
    }
}
