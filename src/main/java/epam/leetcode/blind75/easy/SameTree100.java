package epam.leetcode.blind75.easy;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both are null -> same
        if (p == null && q == null) return true;

        // If one is null -> not same
        if (p == null || q == null) return false;

        // Check current node and recurse
        return (p.val == q.val)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        SameTree100 solver = new SameTree100();
        System.out.println(solver.isSameTree(p, q)); // Output: true
    }
}

