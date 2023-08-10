/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int length = nums.length;
        // states is array of state represented by bit string
        // for example dp[0000] means all 4 elements are negative
        int[] states = new int[1 << length];
        states[0] = -Arrays.stream(nums).sum();
        int count = 0;
        if (states[0] == target) count++;

        for (int i = 1; i < states.length; i++) {
            states [i] = states[i & (i - 1)] + 2 * nums[Integer.numberOfTrailingZeros(i)];
            if (states[i] == target) count++;
        }

        return count;
    }
}
// @lc code=end

