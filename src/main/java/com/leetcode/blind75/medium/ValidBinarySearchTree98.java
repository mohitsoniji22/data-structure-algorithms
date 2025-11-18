package com.leetcode.blind75.medium;

public class ValidBinarySearchTree98 {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ValidBinarySearchTree98 solver = new ValidBinarySearchTree98();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);

        root.left.left = null;
        root.left.right = null;

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        System.out.println(solver.isValidBST(root)); // true
    }
}
