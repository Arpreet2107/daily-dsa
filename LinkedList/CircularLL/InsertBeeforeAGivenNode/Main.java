// Circular Linked List: Insert Before a Given Node
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

    // Method to insert before a given node
    public void insertBefore(int target, int data) {
        Node newNode = new Node(data);
        Node temp = head;
        Node prev = null;

        // Special case: if the node to insert before is the head node
        if (head != null && head.data == target) {
            insertAtBeginning(data);  // reuse insertAtBeginning for this case
            return;
        }

        // Traverse the list to find the target node
        do {
            prev = temp;
            temp = temp.next;
            if (temp.data == target) {
                prev.next = newNode;
                newNode.next = temp;
                if (temp == head) {  // update tail if we're inserting before head
                    tail = newNode;
                }
                return;
            }
        } while (temp != head);

        System.out.println("Node with value " + target + " not found.");
    }

    // Method to add a node to the list
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Method to insert at the beginning (reused)
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
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
        CircularLinkedList cll = new CircularLinkedList();
        cll.addNode(10);
        cll.addNode(20);
        cll.addNode(30);

        cll.insertBefore(20, 15);
        cll.displayList();
    }
}
