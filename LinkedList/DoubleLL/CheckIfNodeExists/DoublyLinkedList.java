public class DoublyLinkedList {
    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;

    // Constructor
    public DoublyLinkedList() {
        this.head = null;
    }

    // Insert a node at the end
    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Check if a node with a specific value exists
    public boolean exists(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;  // Node exists
            }
            current = current.next;
        }
        return false;  // Node does not exist
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Inserting nodes
        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);

        // Check if a node exists
        System.out.println("Does 20 exist? " + list.exists(20));  // Output: true
        System.out.println("Does 50 exist? " + list.exists(50));  // Output: false
    }
}
