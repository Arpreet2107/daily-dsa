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

    // Method to delete a node by value
    public void deleteNode(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        Node prev = null;

        // Special case: If the node to be deleted is the head
        if (head.data == value) {
            if (head.next == head) {
                head = null; // Only one node in the list
            } else {
                prev = head;
                while (prev.next != head) {
                    prev = prev.next;
                }
                prev.next = head.next;
                head = head.next;
            }
        } else {
            // Search for the node to be deleted
            while (temp != head) {
                if (temp.data == value) {
                    prev.next = temp.next;
                    temp.next = null; // Break the link to the next node
                    return;
                }
                prev = temp;
                temp = temp.next;
            }
        }

        System.out.println("Node with value " + value + " deleted.");
    }

    // Method to check for memory leaks (references after deletion)
    public boolean checkMemoryLeak() {
        Node temp = head;
        if (head == null) {
            System.out.println("List is empty.");
            return false;
        }

        do {
            if (temp.next == head) {
                return true; // The node points to the head, no memory leak
            }
            temp = temp.next;
        } while (temp != head);

        return false;
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

        System.out.println("Original Circular Linked List:");
        list.displayList();

        list.deleteNode(30);
        System.out.println("List after deleting node 30:");
        list.displayList();

        // Check for memory leaks
        if (list.checkMemoryLeak()) {
            System.out.println("No memory leak detected.");
        } else {
            System.out.println("Memory leak detected!");
        }
    }
}
