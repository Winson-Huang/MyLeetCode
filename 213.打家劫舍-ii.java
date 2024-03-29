/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(
            robNoRing(Arrays.copyOfRange(nums, 0, nums.length - 1)),
            robNoRing(Arrays.copyOfRange(nums, 1, nums.length))
        );
    }
    public int robNoRing(int [] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }
}
// @lc code=end

