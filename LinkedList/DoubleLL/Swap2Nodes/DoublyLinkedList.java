class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {

    // Function to swap nodes
    public static Node swap2Nodes(Node head, int x, int y) {
        if (x == y) {
            return head;
        }

        // Initialize pointers for node X and node Y
        Node nodeX = null, nodeY = null;
        Node temp = head;
        while (temp != null) {
            if (temp.data == x) {
                nodeX = temp;
            }
            if (temp.data == y) {
                nodeY = temp;
            }
            temp = temp.next;
        }

        if (nodeX == null || nodeY == null) {
            return head;
        }

        // Swap the prev and next pointers
        if (nodeX.prev != null) {
            nodeX.prev.next = nodeY;
        }
        if (nodeX.next != null) {
            nodeX.next.prev = nodeY;
        }
        if (nodeY.prev != null) {
            nodeY.prev.next = nodeX;
        }
        if (nodeY.next != null) {
            nodeY.next.prev = nodeX;
        }

        // Swap next and prev pointers of the nodes
        Node tempPrev = nodeX.prev;
        Node tempNext = nodeX.next;
        nodeX.prev = nodeY.prev;
        nodeX.next = nodeY.next;
        nodeY.prev = tempPrev;
        nodeY.next = tempNext;

        // Swap the head if needed
        if (nodeX == head) {
            head = nodeY;
        } else if (nodeY == head) {
            head = nodeX;
        }

        return head;
    }

    // Helper function to print the list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        // Create a doubly linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;

        System.out.println("Original list:");
        printList(head);

        // Swap nodes 1 and 3
        head = swapNodes(head, 1, 3);

        System.out.println("List after swapping 1 and 3:");
        printList(head);
    }
}
