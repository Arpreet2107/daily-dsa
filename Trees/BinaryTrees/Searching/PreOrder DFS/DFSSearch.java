class Node {
    int data;
    Node left, right;

    Node(int d){
        data = d;
        left = right = null;
    }
}

public class DFSSearch {

    // Preorder DFS Search (Root → Left → Right)
    static boolean searchPreOrder(Node root, int value) {
        if (root == null) return false;

        // Step 1: Visit root
        if (root.data == value) return true;

        // Step 2: Search left subtree
        boolean left = searchPreOrder(root.left, value);
        if (left) return true;

        // Step 3: Search right subtree
        return searchPreOrder(root.right, value);
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

        System.out.println("Preorder Search: " +
            (searchPreOrder(root, target) ? "Found" : "Not Found"));

       
    }
}
