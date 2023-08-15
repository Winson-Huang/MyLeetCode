/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k][2];
        for (int i = 0; i < k; i++) {
            // buy
            dp[i][0] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            dp[0][0] = Math.max(dp[0][0], -prices[i]);
            dp[0][1] = Math.max(dp[0][1], dp[0][0] + prices[i]);
            for (int j = 1; j < k; j++) {
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
            }
        }

        return dp[k - 1][1];
    }
}
// @lc code=end

