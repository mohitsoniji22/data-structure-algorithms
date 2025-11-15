package com.leetcode.blind75.easy;

public class ReverseBits190 {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;         // make space for the next bit
            result |= (n & 1);    // add the last bit of n
            n >>>= 1;             // unsigned shift n to the right
        }

        return result;
    }

    public static void main(String[] args) {
        ReverseBits190 solver = new ReverseBits190();
        int n = 43261596; //n = 43261596   // binary: 00000010100101000001111010011100
        System.out.println(solver.reverseBits(n)); // Output: 964176192  // binary: 00111001011110000010100101000000
    }
}

