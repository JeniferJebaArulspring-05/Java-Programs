class BinarySearchTree {

    // Node class to define the structure of each node in the tree
    static class Node {
        int data;
        Node left, right;
        
        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    // Constructor for the BinarySearchTree
    public BinarySearchTree() {
        root = null;
    }

    // Method to insert a new node with a given key in the tree
    public Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);  // Create a new node if root is null
            return root;
        }

        // Recursively insert the key in the correct position
        if (key < root.data) {
            root.left = insert(root.left, key);  // Insert in left subtree
        } else if (key > root.data) {
            root.right = insert(root.right, key);  // Insert in right subtree
        }

        return root;
    }

    // Method to search for a node with a given key in the tree
    public boolean search(Node root, int key) {
        if (root == null) {
            return false;  // Return false if the root is null (key not found)
        }

        if (root.data == key) {
            return true;  // Return true if the key is found
        }

        // Recursively search in the left or right subtree
        if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    // Method for inorder traversal of the tree (left, root, right)
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);  // Traverse left subtree
            System.out.print(root.data + " ");  // Visit the root node
            inorder(root.right);  // Traverse right subtree
        }
    }

    // Main method to test the BinarySearchTree
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        
        // Inserting nodes into the binary search tree
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);
        
        // Inorder traversal to print the tree
        System.out.print("Inorder traversal of the BST: ");
        tree.inorder(tree.root);
        System.out.println();

        // Searching for a node with key 40
        int keyToSearch = 40;
        System.out.println("Searching for node with key: " + keyToSearch);
        if (tree.search(tree.root, keyToSearch)) {
            System.out.println("Node with key " + keyToSearch + " found");
        } else {
            System.out.println("Node with key " + keyToSearch + " not found");
        }

        // Searching for a node with key 90
        keyToSearch = 90;
        System.out.println("Searching for node with key: " + keyToSearch);
        if (tree.search(tree.root, keyToSearch)) {
            System.out.println("Node with key " + keyToSearch + " found");
        } else {
            System.out.println("Node with key " + keyToSearch + " not found");
        }
    }
}