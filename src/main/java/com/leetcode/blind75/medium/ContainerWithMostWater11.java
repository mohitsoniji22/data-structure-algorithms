package com.leetcode.blind75.medium;

public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            int area = h * width;

            maxArea = Math.max(maxArea, area);

            // Move the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater11 solver = new ContainerWithMostWater11();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(solver.maxArea(height)); // Output: 49
    }
}

