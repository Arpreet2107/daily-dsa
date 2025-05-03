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

    // Check if the DLL is a palindrome
    public boolean isPalindrome() {
        if (head == null) {
            return true;
        }

        Node left = head;
        Node right = head;
        
        // Move right to the end of the list
        while (right.next != null) {
            right = right.next;
        }

        // Compare nodes from both ends
        while (left != null && right != null && left != right && right.next != left) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.prev;
        }
        return true;
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
        list.insertLast(10);

        System.out.println("List:");
        list.displayForward();

        // Check if the list is a palindrome
        if (list.isPalindrome()) {
            System.out.println("The list is a palindrome.");
        } else {
            System.out.println("The list is not a palindrome.");
        }
    }
}
