package epam.leetcode.blind75.easy;

import java.util.Arrays;

/*
🧩 Problem

Given an integer n, return an array ans where ans[i] is the number of 1’s in the binary representation of i, for every 0 ≤ i ≤ n.

✅ Example

Input:
n = 5
Output:
[0,1,1,2,1,2]

Explanation:

0 -> 0 (0 ones)
1 -> 1 (1 one)
2 -> 10 (1 one)
3 -> 11 (2 ones)
4 -> 100 (1 one)
5 -> 101 (2 ones)

 */
public class CountingBits338 {

    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }

    public int[] countBitsBuiltIn(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i); // We already have this function built-in
        }
        return ans;
    }

    //Always check and remember this one
    public int[] countBitsBruteForce(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = popCountKernighan(i);
        }
        return bits;
    }

    //Way to count 1 in any binary representation.
    public static int popCountKernighan(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);  // clear the lowest set bit
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountingBits338 obj = new CountingBits338();
        int n = 5;
        int[] result = obj.countBits(n);
        System.out.println(Arrays.toString(result)); // [0, 1, 1, 2, 1, 2]

        int[] result1 = obj.countBitsBuiltIn(n);
        System.out.println(Arrays.toString(result1)); // [0, 1, 1, 2, 1, 2]

        int[] result2 = obj.countBitsBruteForce(n);
        System.out.println(Arrays.toString(result2)); // [0, 1, 1, 2, 1, 2]
    }
}
