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

    // Method to add a node to the circular linked list
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

    // Method to find the middle node
    public Node findMiddleNode() {
        if (head == null) {
            return null;
        }


        
        Node slow = head;
        Node fast = head;

        // Move fast by 2 steps and slow by 1 step
        while (fast != null && fast.next != head) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
        cll.addNode(40);

        Node middleNode = cll.findMiddleNode();
        if (middleNode != null) {
            System.out.println("Middle node is: " + middleNode.data);
        } else {
            System.out.println("List is empty.");
        }
    }
}
