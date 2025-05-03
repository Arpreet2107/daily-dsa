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

    // Find intersection point of two circular linked lists
    public static Node findIntersection(CircularLinkedList list1, CircularLinkedList list2) {
        if (list1.head == null || list2.head == null) {
            return null;
        }

        Node temp1 = list1.head;
        Node temp2 = list2.head;

        // Traverse both lists to check if there is an intersection point
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;

            if (temp1 == list1.head) temp1 = list2.head;
            if (temp2 == list2.head) temp2 = list1.head;
        }

        return temp1; // Intersection node
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
