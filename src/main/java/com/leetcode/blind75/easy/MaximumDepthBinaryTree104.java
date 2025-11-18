package com.leetcode.blind75.easy;

class TreeNode104 {
    int val;
    TreeNode104 left;
    TreeNode104 right;
    TreeNode104(int val) { this.val = val; }
    TreeNode104(int val, TreeNode104 left, TreeNode104 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaximumDepthBinaryTree104 {
    public int maxDepth(TreeNode104 root) {
        if (root == null) return 0;

        return bsf(root, 0);
    }

    public int bsf(TreeNode104 root, int depth) {
        if(root == null) return depth;

        int leftDepth = bsf(root.left, depth + 1);
        int rightDepth = bsf(root.right, depth + 1);

        return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode104 root = new TreeNode104(3, new TreeNode104(9), new TreeNode104(20, new TreeNode104(15), new TreeNode104(7)));

        MaximumDepthBinaryTree104 solver = new MaximumDepthBinaryTree104();
        System.out.println(solver.maxDepth(root)); // Output: 3
    }
}

