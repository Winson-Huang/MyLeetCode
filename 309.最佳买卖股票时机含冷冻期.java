/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int buyIn = -prices[0];
        int sellOut = 0;
        // canBuy means can buy in tomorrow
        int canBuy = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmpBuyIn = Math.max(buyIn, canBuy - prices[i]);
            int tmpsellOut = buyIn + prices[i];
            int tmpCanBuy = Math.max(canBuy, sellOut);

            buyIn = tmpBuyIn;
            sellOut = tmpsellOut;
            canBuy = tmpCanBuy;
        }
        return Math.max(sellOut, canBuy);
    }
}
// @lc code=end

