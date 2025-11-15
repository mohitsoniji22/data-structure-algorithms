package epam.leetcode.blind75.easy;

public class BestTimeToBuyAndSellStock121 {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Update the minimum price so far
            if (price < minPrice) {
                minPrice = price;
            }
            // Check if selling today gives better profit
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {2, 4, 1, 3, 7, 9, 2, 1};

        int result = maxProfit(prices);
        System.out.println("Maximum Profit: " + result);
    }

}
