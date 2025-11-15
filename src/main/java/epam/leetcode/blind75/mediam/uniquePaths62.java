package epam.leetcode.blind75.mediam;

/*
    * A robot is located at the top-left corner of an m x n grid (marked 'Start' in the diagram below).
    * The robot can only move either down or right at any point in time.
    * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
    * How many possible unique paths are there?
    * Example 1:
    * Input: m = 3, n = 7
    * Output: 28
    * Example 2:
    * Input: m = 3, n = 2
    * Output: 3
    * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
    * 1. Right -> Down -> Down
    * 2. Down -> Down -> Right
    * 3. Down -> Right -> Down
 */
public class uniquePaths62 {
    public static int uniquePaths62(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        int result = uniquePaths62(m, n);
        System.out.println("Number of unique paths in a " + m + "x" + n + " grid: " + result);
    }
}

