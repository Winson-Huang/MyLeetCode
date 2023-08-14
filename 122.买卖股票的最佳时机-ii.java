/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            int unhold = Math.max(dp[0], dp[1] + prices[i]);
            int hold = Math.max(dp[1], dp[0] - prices[i]);
            dp[0] = unhold;
            dp[1] = hold;
        }

        return dp[0];
    }
}
// @lc code=end

