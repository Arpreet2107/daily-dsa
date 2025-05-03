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

    // Split the DLL into two equal halves
    public void split(DoublyLinkedList list1, DoublyLinkedList list2) {
        if (head == null) {
            return;
        }

        Node slow = head;
        Node fast = head;

        // Move slow to the middle and fast to the end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list into two halves
        Node mid = slow;
        list1.head = head;
        list2.head = mid;

        if (mid != null) {
            mid.prev.next = null;
            mid.prev = null;
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

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);
        list.insertLast(40);
        list.insertLast(50);

        System.out.println("Original List:");
        list.displayForward();

        // Splitting the list into two halves
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();
        list.split(list1, list2);

        System.out.println("First Half:");
        list1.displayForward();
        System.out.println("Second Half:");
        list2.displayForward();
    }
}
