class CircularLinkedListUnique {
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

    // Method to insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;  // circular link
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;  // maintain circularity
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
        CircularLinkedListUnique cll = new CircularLinkedListUnique();
        cll.insertAtBeginning(10);
        cll.insertAtBeginning(20);
        cll.insertAtBeginning(30);

        cll.displayList();
    }
}
