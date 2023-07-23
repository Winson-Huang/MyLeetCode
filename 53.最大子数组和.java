/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {

    // dp is more interpretable than greedy
    public int maxSubArray(int[] nums) {
        int preSum = nums[0];
        int maxSum = preSum;
        for (int i = 1; i < nums.length; i++) {
            preSum = Math.max(preSum + nums[i], nums[i]);
            maxSum = Math.max(preSum, maxSum);
        }
        return maxSum;
    }
}
// @lc code=end

