package com.java8;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//Find no of islands in a 2D matrix
public class Sample {

    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for(int i=0; i<nums.length; i++) {
            if(i > maxReach)
                return false;

            maxReach = Math.max(maxReach, i+nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        Sample obj = new Sample();

        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};

        //System.out.println("Can jump (nums1): " + canJump(nums1)); // true
        System.out.println("Can jump (nums2): " + obj.canJump(nums2)); // false

    }
}
