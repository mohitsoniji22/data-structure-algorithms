package com.leetcode.dp;

import java.util.*;

public class DPCoinChange {
    public static void main(String[] args) {
        int[] coins = {9, 6, 5, 1};
        int amount = 11;
        System.out.println("Min coins (DP): " + minCoinsDP(coins, amount));
    }

    static int minCoinsDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
