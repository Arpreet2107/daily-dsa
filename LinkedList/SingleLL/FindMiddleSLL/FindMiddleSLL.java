// Node class to represent each node in the list
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Class to manage the singly linked list
public class FindMiddleSLL {
    Node head;

    // Method to insert a node at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Method to find the middle node using two pointers
    public void findMiddle() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node slow = head;
        Node fast = head;

        // Traverse the list with the two pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;      // Move slow pointer one step
            fast = fast.next.next; // Move fast pointer two steps
        }

        // Slow pointer now points to the middle node
        System.out.println("Middle node: " + slow.data);
    }

    // Method to print the linked list
    public void printList() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test finding the middle node
    public static void main(String[] args) {
        FindMiddleSLL list = new FindMiddleSLL();

        // Insert some nodes to the list
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);

        list.printList(); // Output: 10 -> 20 -> 30 -> 40 -> 50 -> null

        list.findMiddle(); // Output: Middle node: 30
    }
}
