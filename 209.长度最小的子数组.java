/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = -1;
        int minLen = nums.length + 1;
        int sum = 0;
        while (end < nums.length) {
            if (sum < target) {
                if (end + 1 < nums.length) {
                    sum += nums[end + 1];
                }
                end++;
            } else if (sum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }

        if (minLen == nums.length + 1) {
            return 0;
        }

        return minLen;
    }
}
// @lc code=end

