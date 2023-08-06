/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int target = Arrays.stream(nums).sum();
        if (target % 2 == 1) return false;

        // init dp array
        target /= 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < dp.length; i++) {
            if (i >= nums[0]) {
                dp[i] = nums[0];
            }
        }

        // state transfering
        for (int i = 1; i < nums.length; i++) {
            for (int j = dp.length - 1; j - nums[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            if (dp[dp.length - 1] == target) {
                return true;
            }
        }

        return false;
    }
}
// @lc code=end

