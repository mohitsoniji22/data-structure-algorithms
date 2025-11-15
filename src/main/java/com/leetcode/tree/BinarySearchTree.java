package com.leetcode.tree;

// BinarySearchTree.java
public class BinarySearchTree {

    // Node class representing each element of the tree
    public static class Node {
        public int key;
        public Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    public Node root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    // Insert a new key
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive insert helper
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root; // unchanged node
    }

    // Search a key
    boolean search(int key) {
        return searchRec(root, key);
    }

    // Recursive search helper
    boolean searchRec(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    //Using Recursion
    int height(Node root) {
        if (root == null)
            return -1;

        // compute the height of left and right subtrees
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        return Math.max(lHeight, rHeight) + 1;
    }

    static int maxHeight = 0;

    void findHeight(Node root, int depth) {
        if (root == null)
            return;

        // update maximum depth
        if (depth > maxHeight)
            maxHeight = depth;

        findHeight(root.left, depth + 1);
        findHeight(root.right, depth + 1);
    }

    // Recursive function to find the level of the target key
    int getLevel(Node root, int target, int level) {
        if (root == null) {
            return -1;
        }

        if (root.key == target) {
            return level;
        } else if(target < root.key) {
            return getLevel(root.left, target, level + 1);
        } else {
            return getLevel(root.right, target, level + 1);
        }
    }

    static int findParent(Node root, int target, int parent) {
        if (root == null) {
            return -1;
        }

        if (root.key == target) {
            return parent;
        } else if (target < root.key) {
            return findParent(root.left, target, root.key);
        } else {
            return findParent(root.right, target, root.key);
        }
    }

    void printLeafNodes(Node root)
    {
        if (root == null)
            return;

        if (root.left == null && root.right == null)
        {
            System.out.print(root.key + " ");
            return;
        }

        if (root.left != null)
            printLeafNodes(root.left);

        if (root.right != null)
            printLeafNodes(root.right);
    }

    Node getSuccessor(Node root, int target) {

        // Base Case 1: No Inorder Successor
        if (root == null)
            return null;

        // Base Case 2: root is same as target and
        // right child is not empty
        if (root.key == target && root.right != null)
            return leftMost(root.right);

        // Use BST properties to search for
        // target and successor
        Node succ = null;
        Node curr = root;
        while (curr != null) {

            // If curr node is greater, then it
            // is a potential successor
            if (target < curr.key) {
                succ = curr;
                curr = curr.left;
            }

            // If smaller, then successor must
            // be in the right child
            else if (target >= curr.key)
                curr = curr.right;
        }

        return succ;
    }

    // Function to find leftmost node in
    // subtree with given root.
    Node leftMost(Node node) {
        Node curr = node;
        while (curr.left != null)
            curr = curr.left;
        return curr;
    }

    // Counter to track visited nodes
    private int count = 0;

    public void findSecondLargest(Node root) {
        if (root == null) return;

        // Traverse right subtree first (larger values)
        findSecondLargest(root.right);

        // Increment count for each node visited
        count++;

        // If count is 2 → this is second largest
        if (count == 2) {
            System.out.println("Second Largest Element: " + root.key);
            return;
        }

        // Continue with left subtree
        findSecondLargest(root.left);
    }

    // Delete a key
    void delete(int key) {
        root = deleteRec(root, key);
    }

    // Recursive delete helper
    Node deleteRec(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        }
        else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        }
        else {
            // Node with one or no child
            if (root.left == null) { // If left node is null then return right node
                return root.right;
            }
            else if (root.right == null) { // If right node is null then return left node
                return root.left;
            }
            // Node with two children → get inorder successor
            // If left node and right node not null then find the minimum value from right subtree
            // and replace it with the node to be deleted
            int value = minValue(root.right);
            root.key = value;
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    // Find minimum value in a subtree
    int minValue(Node root) {
        int min = root.key;
        while (root.left != null) {
            min = root.left.key;
            root = root.left;
        }
        return min;
    }

    // Print traversals
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key + " ");
        }
    }

    void printLeftNodes(Node root) {
        if(root == null)
            return;
        System.out.print(root.key + " ");
        printLeftNodes(root.left);
    }

    // Driver method
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert elements
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        bst.insert(90);

        // Print traversals
        System.out.println("Inorder traversal:");
        bst.inOrder(bst.root);

        System.out.println("Preorder traversal:");
        bst.preOrder(bst.root);

        System.out.println("Postorder traversal:");
        bst.postOrder(bst.root);

        int height = bst.height(bst.root);
        System.out.println("\nHeight of tree: " + height);

        bst.findHeight(bst.root, 0);
        System.out.println("Height of tree: " + maxHeight);

        System.out.println("Level of node 60: " + bst.getLevel(bst.root, 600, 1));

        System.out.println("Parent of node 60: " + bst.findParent(bst.root, 60, -1));

        System.out.println("Leaf nodes: ");
        bst.printLeafNodes(bst.root);
        System.out.println();

        System.out.println("Successor of 70: " + bst.getSuccessor(bst.root, 70).key);

        bst.findSecondLargest(bst.root);

        // Search elements
        System.out.println("\nSearching for 40: " + bst.search(40));
        System.out.println("Searching for 90: " + bst.search(90));

        // Delete a node
        System.out.println("\nDeleting 20...");
        bst.delete(20);
        bst.inOrder(bst.root);

        System.out.println("\nDeleting 30...");
        bst.delete(30);
        bst.inOrder(bst.root);

        System.out.println("\nDeleting 50...");
        bst.delete(50);
        bst.inOrder(bst.root);
    }
}

