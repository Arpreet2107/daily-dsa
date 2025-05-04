// Java program to find maximum depth using recursion

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class MaxDepthRecursive {

    // Recursive method to find max depth
    int maxDepth(Node root) {
        // Base case: empty tree has depth 0
        if (root == null) return 0;

        // Recursively find depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Depth of current node = 1 + max of left and right subtree depths
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        MaxDepthRecursive tree = new MaxDepthRecursive();
        
        // Creating sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        System.out.println("Root Node Data: " + root.data);
        System.out.println("Left Child Data: " + root.left.data);
        System.out.println("Right Child Data: " + root.right.data);
        System.out.println("Left-Left Grandchild Data: " + root.left.left.data);
        System.out.println("Left-Right Grandchild Data: " + root.left.right.data);
        root.left.right = new Node(5);
        
        int depth = tree.maxDepth(root);
        System.out.println("Maximum Depth (Recursion): " + depth);
    }
}
