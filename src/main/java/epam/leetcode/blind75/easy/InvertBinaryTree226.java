package epam.leetcode.blind75.easy;

/*
Input:

          4
        /   \
        2     7
        / \   / \
        1   3 6   9


Output:

          4
        /   \
        7     2
        / \   / \
        9   6 3   1
Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertBinaryTree226 {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recurse on subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree226 obj = new InvertBinaryTree226();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode inverted = obj.invertTree(root);
        printTree(inverted);
    }

    // Helper method to print tree (inorder)
    static void printTree(TreeNode node) {
        if (node == null) return;
        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }
}

