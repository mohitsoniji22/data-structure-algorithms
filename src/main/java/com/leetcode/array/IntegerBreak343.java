package com.leetcode.array;
/*
Given a number n, split it into at least two positive integers so that their product is maximized.
Return that maximum product.

Example:
Input: n = 10
Output: 36
Explanation: 10 = 3 + 3 + 4 → 3×3×4 = 36

Key insight: The number 3 gives the best product growth when breaking numbers.
 */
public class IntegerBreak343 {

    public int integerBreak(int n) {
        if (n <= 3) return n - 1; // must break into at least two parts

        int product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        product *= n;
        return product;
    }

    public static void main(String[] args) {
        IntegerBreak343 sol = new IntegerBreak343();
        //System.out.println(sol.integerBreak(10)); // Output: 36
        System.out.println(sol.integerBreak(5));  // Output: 18
        System.out.println(sol.integerBreak(4));  // Output: 1
    }
}

