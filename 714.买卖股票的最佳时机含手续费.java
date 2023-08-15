/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buyIn = -prices[0];
        int sellOut = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmpBuyIn = Math.max(buyIn, sellOut - prices[i]);
            int tmpSellOut = Math.max(sellOut, buyIn + prices[i] - fee);

            buyIn = tmpBuyIn;
            sellOut = tmpSellOut;
        }
        // 考虑到手续费因素，不卖出反而可能收益更大，所以要取买入和卖出的最大值
        return Math.max(buyIn, sellOut);
    }
}
// @lc code=end

