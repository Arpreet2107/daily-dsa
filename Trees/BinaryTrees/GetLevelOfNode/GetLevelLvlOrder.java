// Java code to find level of a Node
// in Binary Tree

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

// Function to find the level of 
// the target key
class GetLevelLvlOrder {
    // Function to find the level of the target key
  
    int getLevel(Node root, int target) {
        if (root == null) {
            return -1;
        }

        // Create a queue for level-order traversal
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                // Check if the current node matches the target
                if (curr.data == target) {
                    return level;
                }

                // Push the left and right children to the queue
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
          
            level++;
        }
      
        return -1;
    }

    public static void main(String[] args) {
      	
        // Creating a sample binary tree:
        //       1
        //      / \
        //     2   3
        //    / \ / \
        //   4  5 6  7
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int target = 5;
        GetLevelLvlOrder obj = new GetLevelLvlOrder();
        System.out.println(obj.getLevel(root, target));
    }
}