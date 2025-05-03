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

    // Merge Sort on Circular Linked List
    public void mergeSort() {
        head = mergeSortHelper(head);
    }

    private Node mergeSortHelper(Node head) {
        if (head == null || head.next == head) { // Only one node or empty
            return head;
        }

        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;

        middle.next = head; // Break the list into two halves

        Node left = mergeSortHelper(head);
        Node right = mergeSortHelper(nextToMiddle);

        return merge(left, right);
    }

    private Node getMiddle(Node head) {
        if (head == null) return null;
        Node slow = head, fast = head;
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        if (left.data <= right.data) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.addNode(10);
        list.addNode(30);
        list.addNode(20);
        list.addNode(50);
        list.addNode(40);

        System.out.println("Original Circular Linked List:");
        list.displayList();

        list.mergeSort();

        System.out.println("Sorted Circular Linked List:");
        list.displayList();
    }
}
