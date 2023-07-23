/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] > 0) {
                i--;
                continue;
            }

            int need = 1;
            while (i >= 0 && nums[i] < need) {
                i--;
                need++;
            }
            if (i >= 0) {
                // a legal element is found
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

