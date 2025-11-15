package epam.leetcode.blind75.easy;

/*
🧩 Problem

Given the roots of two binary trees, root and subRoot,
return true if there is a subtree of root that is identical to subRoot,
and false otherwise.

👉 A subtree is a tree that consists of a node in root and all of that node's descendants.

✅ Example

Input:

root = [3,4,5,1,2], subRoot = [4,1,2]


Output:
true

Explanation:
The subtree starting at node 4 in root matches exactly with subRoot.

    3
   / \
  4   5
 / \
1   2


subRoot =

  4
 / \
1   2

 */
public class SubtreeOfAnotherTree572 {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        if (isSameTree(root, subRoot)) return true;

        // Check recursively in left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    public static void main(String[] args) {
        SubtreeOfAnotherTree572 obj = new SubtreeOfAnotherTree572();

        // Build root tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        // Build subRoot
        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println(obj.isSubtree(root, subRoot)); // true
    }
}

