/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int buyOnce = -prices[0];
        int buyTwice = -prices[0];
        int sellOnce = 0;
        int sellTwice = 0;

        for (int i = 1; i < prices.length; i++) {
            buyOnce = Math.max(buyOnce, -prices[i]);
            sellOnce = Math.max(sellOnce, buyOnce + prices[i]);
            buyTwice = Math.max(buyTwice, sellOnce - prices[i]);
            sellTwice = Math.max(sellTwice, buyTwice + prices[i]);
        }

        return sellTwice;
    }
}
// @lc code=end

