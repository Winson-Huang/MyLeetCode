/*
 * @lc app=leetcode.cn id=1049 lang=java
 *
 * [1049] 最后一块石头的重量 II
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int lastStoneWeightII(int[] stones) {
        // this is a 0-1 pack problem
        int sum = Arrays.stream(stones).sum();
        // target may not be equal to sum / 2, because sum can be odd
        // but it do no harm
        int target = sum / 2;

        int[] dp = new int[target + 1];
        for (int i = stones[0]; i < target + 1; i++) {
            dp[i] = stones[0];
        }

        for (int i = 1; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - dp[target] - dp[target];
    }
}
// @lc code=end

