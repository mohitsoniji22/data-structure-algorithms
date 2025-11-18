package com.leetcode.blind75.hard;

import com.leetcode.blind75.medium.LevelOrderBTFromPreAndInOrder105.TreeNode;

public class BinaryTreeMaximumPathSum124 {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        // max gain from left and right child
        int left = Math.max(0, maxGain(node.left));
        int right = Math.max(0, maxGain(node.right));

        // price of the new path using both children and this node
        int price = node.val + left + right;

        // update global max
        maxSum = Math.max(maxSum, price);

        // return max gain going upwards (can't take both sides)
        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        System.out.println("Max Path Sum: " + new BinaryTreeMaximumPathSum124().maxPathSum(root));
    }
}
