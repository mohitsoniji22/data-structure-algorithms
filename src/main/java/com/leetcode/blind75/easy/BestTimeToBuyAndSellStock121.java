package com.leetcode.blind75.easy;

public class BestTimeToBuyAndSellStock121 {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 1) return 0;

        int maxProfit = 0, profit = 0;
        int buy=prices[0];

        for(int i=1; i<prices.length; i++) {
            if(prices[i] < buy)
                buy = prices[i];
            profit = prices[i] - buy;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {2, 4, 1, 3, 7, 9, 2, 1};

        int result = maxProfit(prices);
        System.out.println("Maximum Profit: " + result);
    }

}
