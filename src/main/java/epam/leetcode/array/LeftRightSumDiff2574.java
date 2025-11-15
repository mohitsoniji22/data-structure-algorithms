package epam.leetcode.array;

/*
    * 2574. Left and Right Sum Differences
    * Easy
    * 1. You are given a 0-indexed array nums of n integers.
    * 2. The left sum of an index i is the sum of all elements to the left of i.
    *    If there are no elements to the left of i, the left sum is considered to be 0.
    * 3. The right sum of an index i is the sum of all elements to the right of i.
    *    If there are no elements to the right of i, the right sum is considered to be 0.
    * 4. The left-right difference of an index i is the absolute difference between the left sum and
    *    the right sum.
    * 5. Return an array of size n where the value at the ith index is the left-right difference
    *    at index i of the given array.
    * Example 1:
    * Input: nums = [10,4,8,3]
    * Output: [15,1,11,22]
    * Explanation:
    * The left-right differences are calculated as follows:
    * - i = 0: left sum = 0, right sum = 4 + 8 + 3 = 15, left-right difference = |0 - 15| = 15
    * - i = 1: left sum = 10, right sum = 8 + 3 = 11, left-right difference = |10 - 11| = 1
    * - i = 2: left sum = 10 + 4 = 14, right sum = 3, left-right difference = |14 - 3| = 11
    * - i = 3: left sum = 10 + 4 + 8 = 22, right sum = 0, left-right difference = |22 - 0| = 22
    * Example 2:
 */
class LeftRightSumDiff2574 {
    public int[] leftRightDifference(int[] nums) {
        int[] leftSumArray = new int[nums.length];
        int[] rightSumArray = new int[nums.length];
        int[] leftRightDiff = new int[nums.length];
        int leftSum=0, rightSum=0;
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                leftSum += nums[j];
            }
            leftSumArray[i] = leftSum;
            leftSum = 0;

            for(int j=i+1; j<nums.length; j++) {
                rightSum += nums[j];
            }
            rightSumArray[i] = rightSum;
            rightSum = 0;
        }

        for(int k=0; k<nums.length; k++) {
            int diff = leftSumArray[k] - rightSumArray[k];
            if(diff < 0) {
                diff = diff * (-1);
            }
            leftRightDiff[k] = diff;
        }

        return leftRightDiff;
    }

    public int[] leftRightDifferenceLessTimeComplex(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int[] answer = new int[n];

        // Compute leftSum
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }

        // Compute rightSum
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }

        // Compute answer
        for (int i = 0; i < n; i++) {
            answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        LeftRightSumDiff2574 solver = new LeftRightSumDiff2574();
        int[] nums = {10,4,8,3};
        int[] result = solver.leftRightDifference(nums);

        for(int val : result) {
            System.out.print(val + " ");
        }
    }
}