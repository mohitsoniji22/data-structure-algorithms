package epam.leetcode.array;

import java.util.Arrays;
import java.util.Stack;

public class NextRightElementInaCircularArray503 {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i>=0; i--) {
            if(stack.empty()) {
                result[i] = -1;
                stack.push(nums[i]);
            } else {
                while(!stack.empty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }
                result[i] = stack.empty() ? -1 : stack.peek();
                stack.push(nums[i]);
            }
        }
        return result;
    }

    public int[] nextGreaterElementsInCircularArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(result, -1); // Default if no greater element found

        // Traverse twice (simulate circular array)
        for (int i = 2 * n - 1; i >= 0; i--) {
            int num = nums[i % n];

            // Pop smaller elements
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }

            // Only fill result in first pass
            if (i < n && !stack.isEmpty()) {
                result[i] = stack.peek();
            }

            // Push current element
            stack.push(num);
        }

        return result;
    }

    public static void main(String[] args) {
        NextRightElementInaCircularArray503 s = new NextRightElementInaCircularArray503();
        int[] nums = {1,2,1};
        int[] result = s.nextGreaterElementsInCircularArray(nums);
        for(int val : result) {
            System.out.print(val + " ");  // Output: 2 -1 2
        }
    }
}
