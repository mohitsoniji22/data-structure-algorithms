package com.leetcode.array;

// Node definition
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    public Node(int val) { this.val = val; }
}

public class PopulateNextRightPointerInEachNode116 {

    // Constant space solution
    public Node connect(Node root) {
        if (root == null) return null;

        Node leftmost = root;

        while (leftmost.left != null) {
            Node head = leftmost;

            while (head != null) {
                // connection 1
                head.left.next = head.right;

                // connection 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }

            leftmost = leftmost.left;
        }

        return root;
    }

    // Helper to print next pointers level by level
    public void printLevels(Node root) {
        Node levelStart = root;
        while (levelStart != null) {
            Node curr = levelStart;
            while (curr != null) {
                System.out.print(curr.val + " -> ");
                if (curr.next != null) {
                    System.out.print(curr.next.val + "  ");
                } else {
                    System.out.print("null  ");
                }
                curr = curr.next;
            }
            System.out.println();
            levelStart = levelStart.left;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        PopulateNextRightPointerInEachNode116 solution = new PopulateNextRightPointerInEachNode116();

        // Build tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Connect next pointers
        solution.connect(root);

        // Print levels
        solution.printLevels(root);
    }
}

