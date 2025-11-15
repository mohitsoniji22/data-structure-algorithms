package com.leetcode.blind75.easy;
/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

 */
public class ClimbingStairs70 {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int first = 1;  // ways to reach step 1
        int second = 2; // ways to reach step 2

        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }

    public static void main(String[] args) {
        ClimbingStairs70 solver = new ClimbingStairs70();
        System.out.println(solver.climbStairs(5)); // Output: 8
    }
}
