/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // 该版本代码是通用完全背包思路（外层循环物品，内层循环容量）的解法，
        // 并且将二维 dp 数组压缩为一维 dp 数组。与力扣官方题解思路不同。
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

