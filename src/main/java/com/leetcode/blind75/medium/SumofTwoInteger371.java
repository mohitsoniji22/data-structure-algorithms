package com.leetcode.blind75.medium;

public class SumofTwoInteger371 {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;  // carry: AND Operation and left shift
            a = a ^ b;                 // sum without carry: XOR Operation
            b = carry;                 // add carry in next step:
        }
        return a;
    }

    public static void main(String[] args) {
        SumofTwoInteger371 solver = new SumofTwoInteger371();
        int a = 5, b = 7;
        int result = solver.getSum(a, b);
        System.out.println("Sum of " + a + " and " + b + " is: " + result); // Output: 12
    }
}
