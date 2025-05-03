class CircularLinkedListWithTail {
    Node head;
    Node tail;

    // Node class for Circular Linked List with Tail
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

    // Method to delete a node
    public void deleteNode(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        if (head.data == value) {
            // Special case: if head node is to be deleted
            if (head == tail) {
                head = null; // Single node case
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            System.out.println("Node " + value + " deleted.");
            return;
        }

        // Traverse the list to find the node to delete
        do {
            if (temp.next.data == value) {
                temp.next = temp.next.next;
                if (temp.next == head) {
                    tail = temp; // Update tail if last node is deleted
                }
                System.out.println("Node " + value + " deleted.");
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Node " + value + " not found.");
    }

    public static void main(String[] args) {
        CircularLinkedListWithTail list = new CircularLinkedListWithTail();
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);

        System.out.println("Circular Linked List with Tail:");
        list.displayList();

        list.deleteNode(30);
        list.displayList();
    }
}
