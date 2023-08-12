/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1, amount + 1, Integer.MAX_VALUE);
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}
// @lc code=end

