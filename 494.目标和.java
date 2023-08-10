/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int negAbs = (sum - target) / 2;
        if (negAbs < 0 || negAbs * 2 != (sum - target)) {
            return 0;
        }

        int[] dp = new int[negAbs + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = negAbs; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }

        return dp[negAbs];
    }
}
// @lc code=end

