import java.util.LinkedList;
import java.util.Queue;

// Class representing each node in the binary tree
class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class BinaryTreeInsertion {
    Node root;

    // Method to insert a new node in the binary tree in level order
    public void insert(int value) {
        Node newNode = new Node(value); // Step 1: Create a new node

        // Step 2: If tree is empty, make new node the root
        if (root == null) {
            root = newNode;
            return;
        }

        // Step 3: Use a queue to perform level order traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Step 4: Traverse the tree until we find an empty spot
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // Step 5: Check if left child is empty
            if (current.left == null) {
                current.left = newNode; // Insert as left child
                break;
            } else {
                queue.add(current.left); // Else, add left child to queue
            }

            // Step 6: Check if right child is empty
            if (current.right == null) {
                current.right = newNode; // Insert as right child
                break;
            } else {
                queue.add(current.right); // Else, add right child to queue
            }
        }
    }

    // Method to print the tree using Level Order Traversal
    public void levelOrder() {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        System.out.print("Level Order: ");
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    // Main method to test the insertion
    public static void main(String[] args) {
        BinaryTreeInsertion tree = new BinaryTreeInsertion();

        // Inserting nodes into the binary tree
        tree.insert(1); // root
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        // Displaying the tree in level order after insertion
        tree.levelOrder(); // Output: 1 2 3 4 5 6 7
    }
}
