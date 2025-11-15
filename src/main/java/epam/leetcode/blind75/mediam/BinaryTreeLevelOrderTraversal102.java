package epam.leetcode.blind75.mediam;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) return;
        if (res.size() == level)
            res.add(new ArrayList<>());
        res.get(level).add(node.val);
        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    }


    public List<Integer> levelOrderInAList(TreeNode root) {
        List<Integer> resInAList = new ArrayList<>();
        dfsInAList(root, resInAList);
        return resInAList;
    }

    private void dfsInAList(TreeNode node, List<Integer> resInAList) {
        if (node == null) return;
        resInAList.add(node.val);
        dfsInAList(node.left, resInAList);
        dfsInAList(node.right, resInAList);
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal102 solver = new BinaryTreeLevelOrderTraversal102();

        // Constructing the binary tree:
        //       3
        //      / \
        //     9  20
        //       /  \
        //      15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = solver.levelOrder(root);

        System.out.println("Level Order Traversal: " + result);

        List<Integer> resultInAList = solver.levelOrderInAList(root);

        System.out.println("Level Order Traversal In A List: " + resultInAList);
    }
}
