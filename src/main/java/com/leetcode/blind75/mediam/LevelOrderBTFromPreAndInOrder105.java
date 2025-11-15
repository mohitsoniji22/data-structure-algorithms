package com.leetcode.blind75.mediam;

import java.util.*;

public class LevelOrderBTFromPreAndInOrder105 {
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int preIndex = 0;
    private int[] preorder;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        this.preorder = preorder;
        preIndex = 0;

        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(0, inorder.length - 1);
    }

    private TreeNode build(int inLeft, int inRight) {
        if (inLeft > inRight) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int inRootIndex = inorderIndexMap.get(rootVal);

        root.left = build(inLeft, inRootIndex - 1);
        root.right = build(inRootIndex + 1, inRight);

        return root;
    }

    // Serializes tree to LeetCode-style list with null placeholders
    public static List<String> serialize(TreeNode root) {
        List<String> out = new ArrayList<>();
        if (root == null) return out;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                out.add(String.valueOf(node.val));
                q.add(node.left);
                q.add(node.right);
            } else {
                out.add("null");
            }
        }

        // trim trailing "null"s
        int i = out.size() - 1;
        while (i >= 0 && out.get(i).equals("null")) {
            out.remove(i);
            i--;
        }
        return out;
    }

    public static void main(String[] args) {
        LevelOrderBTFromPreAndInOrder105 solver = new LevelOrderBTFromPreAndInOrder105();

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode root = solver.buildTree(preorder, inorder);
        List<String> serializedTree = serialize(root);

        System.out.println("Serialized Tree: " + serializedTree);
    }
}
