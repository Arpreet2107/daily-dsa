import java.util.*;

// Node class representing each node in the binary tree
class Node {
    int data;
    Node left, right;

    Node(int d){
        data = d;
        left = right = null;
    }
}

public class DFSSearch {
    // Depth-First Search (DFS) is a traversal method that explores as far as possible along each branch before backtracking.

    

    // Level Order (BFS) Search
    static boolean searchLevelOrder(Node root, int value) {
        if (root == null) return false;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // Visit current node
            if (current.data == value) return true;

            // Enqueue left and right children
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        return false;
    }

    public static void main(String[] args) {
        // Construct a sample binary tree
        /*
                  2
                 / \
                3   4
               / \
              5   6
        */
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);

        int target = 6;

        System.out.println("Searching for value: " + target);

       
        System.out.println("Level Order (BFS) Search: " +
            (searchLevelOrder(root, target) ? "Found" : "Not Found"));
    }
}
