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

    // Delete the middle node
    public void deleteMiddle() {
        if (head == null) {
            return;
        }

        Node slow = head;
        Node fast = head;

        // Move fast two steps and slow one step at a time
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // If the list has only one node
        if (slow.prev == null && slow.next == null) {
            head = null;
        } else if (slow.prev != null) {
            slow.prev.next = slow.next;
        }
        if (slow.next != null) {
            slow.next.prev = slow.prev;
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

        System.out.println("List before deletion:");
        list.displayForward();

        // Delete the middle node
        list.deleteMiddle();

        System.out.println("List after deletion of middle node:");
        list.displayForward();
    }
}
