// Node class represents each element in the singly linked list
class Node {
    int data;        // Stores the value of the node
    Node next;       // Pointer to the next node in the list

    // Constructor to create a new node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Singly linked list class
public class sllDemo {
    Node head; // Head points to the first node in the list

    // Add a node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data); // Create a new node

        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse to the end of the list
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Link the new node to the last node
        current.next = newNode;
    }

    // Insert a node at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head; // Point the new node's next to current head
        head = newNode;      // Make newNode the new head
    }

    // Insert a node at a specific position (0-based index)
    public void insertAt(int index, int data) {
        if (index == 0) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;

        // Traverse to the node just before the desired index
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                System.out.println("Index out of bounds");
                return;
            }
            current = current.next;
        }

        // Insert the node at the given index
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete a node at a specific index
    public void deleteAt(int index) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Delete the head node
        if (index == 0) {
            head = head.next;
            return;
        }

        Node current = head;

        // Traverse to the node just before the one to delete
        for (int i = 0; i < index - 1; i++) {
            if (current.next == null) {
                System.out.println("Index out of bounds");
                return;
            }
            current = current.next;
        }

        // Unlink the node to be deleted
        if (current.next == null) {
            System.out.println("Index out of bounds");
            return;
        }

        current.next = current.next.next;
    }

    // Display the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Get the size of the list
    public int size() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    // Search for a value in the list
    public boolean search(int key) {
        Node current = head;

        while (current != null) {
            if (current.data == key)
                return true;
            current = current.next;
        }

        return false;
    }

    // Main method to test the singly linked list
    public static void main(String[] args) {
        sllDemo list = new sllDemo();

        list.insert(10);  // Insert at end
        list.insert(20);
        list.insert(30);
        list.insertAtBeginning(5);  // Insert at beginning
        list.insertAt(2, 15);       // Insert at index 2

        System.out.print("Linked List: ");
        list.display();  // Display list

        System.out.println("Size: " + list.size());  // Display size

        list.deleteAt(3);  // Delete element at index 3
        System.out.print("After deletion: ");
        list.display();

        System.out.println("Search 20: " + list.search(20));  // Search for value
        System.out.println("Search 100: " + list.search(100));
    }
}
