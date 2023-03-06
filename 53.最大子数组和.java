/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        // this solution can be proven using dynamic programming
        int maxSum = nums[0], preSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if (preSum < 0) {
                preSum = nums[i];
            } else {
                preSum = preSum + nums[i];
            }
            if (preSum > maxSum) {
                maxSum = preSum;
            }
        }
        return maxSum;
    }
}
// @lc code=end

