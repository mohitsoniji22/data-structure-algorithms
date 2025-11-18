package com.leetcode.blind75.easy;

public class NumberOf1Bits191 {
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n &= (n - 1);  // clear the lowest set bit
            count++;
        }

        return count;
    }

    public int hammingWeight2(int n) {
        String number = Integer.toBinaryString(n);
        char[] chars = number.toCharArray();
        int count = 0;
        for(char c : chars) {
            if(c == '1') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits191 solver = new NumberOf1Bits191();
        int n = 0b00000000000000000000000000001011; // binary literal
        System.out.println(solver.hammingWeight(n)); // Output: 3
    }
}
