class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    Node root;

    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    void delete(int data) {
        root = deleteNode(root, data);
    }

    Node deleteNode(Node currentNode, int data) {
        if (currentNode == null) {
            return null;
        }
        if (data < currentNode.data) {
            currentNode.left = deleteNode(currentNode.left, data);
        } else if (data > currentNode.data) {
            currentNode.right = deleteNode(currentNode.right, data);
        } else {
            if (currentNode.left == null) {
                return currentNode.right;
            } else if (currentNode.right == null) {
                return currentNode.left;
            }
        }
        return currentNode;
    }

    void printTree() {
        printTree(root);
        System.out.println();
    }

    void printTree(Node node) {
        if (node != null) {
            printTree(node.left);
            System.out.print(node.data + " ");
            printTree(node.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);

        System.out.println("Before deletion:");
        bst.printTree();

        bst.delete(70);

        System.out.println("After deletion:");
        bst.printTree();
    }
}