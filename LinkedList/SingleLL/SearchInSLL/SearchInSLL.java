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
public class SearchInSLL {
    Node head;

    // Method to insert a node at the end
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

    // Method to search for an element and return its position (1-based)
    public int searchElement(int key) {
        Node current = head;
        int position = 1;

        while (current != null) {
            if (current.data == key) {
                return position; // Element found
            }
            current = current.next;
            position++;
        }

        return -1; // Element not found
    }

    // Method to print the list
    public void printList() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test searching
    public static void main(String[] args) {
        SearchInSLL list = new SearchInSLL();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        list.printList();

        int key = 30;
        int position = list.searchElement(key);
        if (position != -1) {
            System.out.println("Element " + key + " found at position: " + position);
        } else {
            System.out.println("Element " + key + " not found in the list.");
        }
    }
}
