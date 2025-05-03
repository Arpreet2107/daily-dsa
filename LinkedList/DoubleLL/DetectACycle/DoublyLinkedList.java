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

    // Detect cycle using Floyd’s Cycle-Finding Algorithm
    public boolean hasCycle() {
        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;  // Move slow pointer one step
            fast = fast.next.next;  // Move fast pointer two steps

            if (slow == fast) {  // If they meet, a cycle is detected
                return true;
            }
        }
        return false;  // No cycle
    }

    // Display the list from head to tail
    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);

        // Introduce a cycle for testing
        list.head.next.next.next = list.head.next;  // Creating a cycle

        if (list.hasCycle()) {
            System.out.println("The list contains a cycle.");
        } else {
            System.out.println("The list does not contain a cycle.");
        }
    }
}
