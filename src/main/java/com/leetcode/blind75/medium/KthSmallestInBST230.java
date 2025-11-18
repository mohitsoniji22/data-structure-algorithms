package com.leetcode.blind75.medium;


import java.util.Collections;
import java.util.PriorityQueue;

//   Definition for a binary tree node.
class TreeNode230 {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode230() {
    }

    TreeNode230(int val) {
        this.val = val;
    }

    TreeNode230(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class KthSmallestInBST230 {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        inorderTraversal(root, maxHeap, k);
        return maxHeap.peek();
    }

    private void inorderTraversal(TreeNode root, PriorityQueue<Integer> maxHeap, int k) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, maxHeap, k);
        maxHeap.offer(root.val);
        if(maxHeap.size() > k) {
            maxHeap.poll();
        }
        inorderTraversal(root.right, maxHeap, k);
    }

    public static void main(String[] args) {
        KthSmallestInBST230 solver = new KthSmallestInBST230();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 2;
        int result = solver.kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element in the BST is: " + result); // Output: 1
    }
}
