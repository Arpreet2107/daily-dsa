
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

    // Postorder DFS Search (Left → Right → Root)
    static boolean searchPostOrder(Node root, int value) {
        if (root == null) return false;

        // Step 1: Search left subtree
        boolean left = searchPostOrder(root.left, value);

        // Step 2: Search right subtree
        boolean right = searchPostOrder(root.right, value);

        if (left || right) return true;

        // Step 3: Visit root
        return root.data == value;
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

        

        System.out.println("Postorder Search: " +
            (searchPostOrder(root, target) ? "Found" : "Not Found"));

        
    }
}
