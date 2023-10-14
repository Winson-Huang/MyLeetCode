/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int start = 0, end = nums.length - 1;
        int[] results = new int[nums.length];
        int resI = results.length - 1;
        while (start <= end) {
            if (Math.abs(nums[start]) < Math.abs(nums[end])) {
                results[resI] = nums[end] * nums[end];
                end--;
                resI--;
            } else {
                results[resI] = nums[start] * nums[start];
                start++;
                resI--;
            }
        }
        return results;
    }
}
// @lc code=end

