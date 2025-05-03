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
public class FindNthFromEndSLL {
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

    // Method to find the Nth node from the end using two pointers
    public void findNthFromEnd(int n) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node first = head;
        Node second = head;

        // Move the first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (first == null) {
                System.out.println("The list has fewer than " + n + " elements.");
                return;
            }
            first = first.next;
        }

        // Now move both pointers one step at a time
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // The second pointer is now at the Nth node from the end
        System.out.println("The " + n + "th node from the end is: " + second.data);
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

    // Main method to test finding the Nth node from the end
    public static void main(String[] args) {
        FindNthFromEndSLL list = new FindNthFromEndSLL();

        // Insert some nodes to the list
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);

        list.printList(); // Output: 10 -> 20 -> 30 -> 40 -> 50 -> null

        list.findNthFromEnd(2); // Output: The 2nd node from the end is: 40
        list.findNthFromEnd(5); // Output: The 5th node from the end is: 10
        list.findNthFromEnd(6); // Output: The list has fewer than 6 elements.
    }
}
