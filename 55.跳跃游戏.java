/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int cover = nums[0];
        int i = 0;
        while (i <= cover) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) return true;
            i++;
        }
        return false;
    }
}
// @lc code=end

