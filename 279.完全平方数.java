/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        int[] candidates = new int[(int) Math.sqrt(n)];
        for (int i = 0; i < candidates.length; i++) {
            candidates[i] = (i + 1) * (i + 1);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1, n + 1, Integer.MAX_VALUE);
        for (int i = 0; i < candidates.length; i++) {
            for (int j = candidates[i]; j < dp.length; j++) {
                if (dp[j - candidates[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - candidates[i]] + 1);
                }
            }
        }

        return dp[n];
    }
}
// @lc code=end

