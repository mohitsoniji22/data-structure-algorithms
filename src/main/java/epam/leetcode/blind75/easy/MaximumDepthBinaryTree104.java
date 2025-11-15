package epam.leetcode.blind75.easy;

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
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode104 root = new TreeNode104(3, new TreeNode104(9), new TreeNode104(20, new TreeNode104(15), new TreeNode104(7)));

        MaximumDepthBinaryTree104 solver = new MaximumDepthBinaryTree104();
        System.out.println(solver.maxDepth(root)); // Output: 3
    }
}

