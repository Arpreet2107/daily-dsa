import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class BinaryTreeDeletion {
    Node root;

    // Method to delete a node in binary tree
    void delete(int key) {
        if (root == null) return;

        // If tree has only one node and it's the key
        if (root.left == null && root.right == null) {
            if (root.data == key) root = null;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node keyNode = null, temp = null;

        // Level order traversal to find keyNode and last node
        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.data == key) keyNode = temp;

            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }

        if (keyNode != null && temp != null) {
            keyNode.data = temp.data; // replace keyNode with deepest node
            deleteDeepest(root, temp); // delete deepest node
        }
    }

    // Delete the deepest node
    void deleteDeepest(Node root, Node delNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                } else queue.add(temp.left);
            }

            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                } else queue.add(temp.right);
            }
        }
    }

    // Utility method to print level order (BFS)
    void printLevelOrder() {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTreeDeletion tree = new BinaryTreeDeletion();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4);

        System.out.println("Level Order before deletion:");
        tree.printLevelOrder();

        tree.delete(3); // deleting node with value 3

        System.out.println("Level Order after deletion:");
        tree.printLevelOrder();
    }
}
