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

    // Merge two sorted DLLs into a single sorted DLL
    public DoublyLinkedList merge(DoublyLinkedList other) {
        DoublyLinkedList mergedList = new DoublyLinkedList();
        Node thisCurrent = head;
        Node otherCurrent = other.head;

        while (thisCurrent != null && otherCurrent != null) {
            if (thisCurrent.data <= otherCurrent.data) {
                mergedList.insertLast(thisCurrent.data);
                thisCurrent = thisCurrent.next;
            } else {
                mergedList.insertLast(otherCurrent.data);
                otherCurrent = otherCurrent.next;
            }
        }

        // Add remaining nodes from either list
        while (thisCurrent != null) {
            mergedList.insertLast(thisCurrent.data);
            thisCurrent = thisCurrent.next;
        }

        while (otherCurrent != null) {
            mergedList.insertLast(otherCurrent.data);
            otherCurrent = otherCurrent.next;
        }

        return mergedList;
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
        DoublyLinkedList list1 = new DoublyLinkedList();
        list1.insertLast(10);
        list1.insertLast(20);
        list1.insertLast(30);

        DoublyLinkedList list2 = new DoublyLinkedList();
        list2.insertLast(15);
        list2.insertLast(25);
        list2.insertLast(35);

        System.out.println("List 1:");
        list1.displayForward();
        System.out.println("List 2:");
        list2.displayForward();

        // Merging the two lists
        DoublyLinkedList mergedList = list1.merge(list2);

        System.out.println("Merged List:");
        mergedList.displayForward();
    }
}
