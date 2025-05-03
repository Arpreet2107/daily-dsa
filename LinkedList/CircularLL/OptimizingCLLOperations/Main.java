class CircularLinkedList {
    Node head;
    Node tail; // Reference to the tail node

    // Node class for Circular Linked List
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to add a node at the end (optimized)
    public void addNode(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // Circular reference
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain the circular reference
        }
    }

    // Method to delete a node by value (optimized)
    public void deleteNode(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        Node prev = null;

        // Special case: If the node to be deleted is the head
        if (head.data == value) {
            if (head == tail) {
                head = null; // Only one node in the list
                tail = null;
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
                    if (temp == tail) {
                        tail = prev; // Update the tail if the last node is deleted
                    }
                    return;
                }
                prev = temp;
                temp = temp.next;
            }
        }

        System.out.println("Node with value " + value + " deleted.");
    }

    // Method to search a node by value (optimized)
    public boolean searchNode(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return false;
        }

        Node temp = head;
        do {
            if (temp.data == value) {
                return true;
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

    // Time Complexity Analysis:
    // Add Operation: O(1)
    // Delete Operation: O(n)
    // Search Operation: O(n)

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

        if (list.searchNode(20)) {
            System.out.println("Node 20 found.");
        } else {
            System.out.println("Node 20 not found.");
        }
    }
}
