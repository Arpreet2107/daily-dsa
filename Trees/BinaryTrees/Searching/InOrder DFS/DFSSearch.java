
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

    

    // Inorder DFS Search (Left → Root → Right)
    static boolean searchInOrder(Node root, int value) {
        if (root == null) return false;

        // Step 1: Search left subtree
        boolean left = searchInOrder(root.left, value);
        if (left) return true;

        // Step 2: Visit root
        if (root.data == value) return true;

        // Step 3: Search right subtree
        return searchInOrder(root.right, value);
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

        

        System.out.println("Inorder Search: " +
            (searchInOrder(root, target) ? "Found" : "Not Found"));

       
    }
}
