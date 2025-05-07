// Java code to find level of a Node in Binary Tree

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class GetLevelRecursion {
  
    // Recursive function to find the level of the target key
    int getLevel(Node root, int target, int level) {
        if (root == null) {
            return -1;
        }

        // If the target key matches the current node's 
      	// data, return the level
        if (root.data == target) {
            return level;
        }

        // Recursively call for left and right subtrees
        int leftLevel = getLevel(root.left, target, level + 1);
        if (leftLevel != -1) {
            return leftLevel;
        }

        return getLevel(root.right, target, level + 1);
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
        GetLevelRecursion recursion = new GetLevelRecursion();
        System.out.println(recursion.getLevel(root, target, 1));
    }
}