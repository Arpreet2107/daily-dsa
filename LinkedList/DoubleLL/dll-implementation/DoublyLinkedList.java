class DoublyLinkedList {

    // Node class represents each element in the doubly linked list
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
    private Node tail;

    // Constructor
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Add a node at the end
    public void append(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Add a node at the beginning
    public void prepend(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    // Remove a node by data
    public void remove(int data) {
        if (head == null) return;

        Node current = head;

        // If data is in the head node
        if (current.data == data) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        // Traverse the list to find the node to delete
        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) return;  // Node not found

        // Unlink the node from the list
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }
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

    // Display the list from tail to head
    public void displayBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    // Main method to test the doubly linked list
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Adding nodes to the list
        list.append(10);
        list.append(20);
        list.append(30);

        // Display the list
        System.out.println("Forward Display:");
        list.displayForward();  // Output: 10 <-> 20 <-> 30 <-> null

        System.out.println("Backward Display:");
        list.displayBackward(); // Output: 30 <-> 20 <-> 10 <-> null

        // Prepending a node
        list.prepend(5);
        System.out.println("After Prepending 5:");
        list.displayForward();  // Output: 5 <-> 10 <-> 20 <-> 30 <-> null

        // Removing a node
        list.remove(20);
        System.out.println("After Removing 20:");
        list.displayForward();  // Output: 5 <-> 10 <-> 30 <-> null
    }
}
