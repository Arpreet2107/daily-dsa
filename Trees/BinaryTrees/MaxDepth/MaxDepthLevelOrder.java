// Java program to find maximum depth using level order traversal (BFS)

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class MaxDepthLevelOrder {

    // Method to find max depth using level order
    int maxDepth(Node root) {
        // Base case: empty tree
        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        // Traverse each level
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes in current level

            // Process all nodes in current level
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                // Add child nodes of current node
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            // Increase depth after processing each level
            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {
        MaxDepthLevelOrder tree = new MaxDepthLevelOrder();
        
        // Creating sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int depth = tree.maxDepth(root);
        System.out.println("Maximum Depth (Level Order): " + depth);
    }
}
