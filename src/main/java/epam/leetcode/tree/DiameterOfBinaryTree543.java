package epam.leetcode.tree;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

public class DiameterOfBinaryTree543 {

    private static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Update the maximum diameter found so far
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return the height of the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private static int diameterOfBinaryTree2(TreeNode root) {
        int leftHight = 0;
        int rightHight = 0;

        TreeNode originalRoot = root;

        while(root.left != null) {
            leftHight++;
            root = root.left;
        }

        if(originalRoot.right != null) {
            rightHight++;
            root = originalRoot.right;
        }

        while(root.left != null) {
            rightHight++;
            root = root.left;
        }

        return leftHight+rightHight;
    }

    // 🧪 Test
    public static void main(String[] args) {
        // Example tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);


        System.out.println("Diameter of the Binary Tree: " + diameterOfBinaryTree(root));

        System.out.println("Diameter of the Binary Tree 2: " + diameterOfBinaryTree2(root));

    }
}
