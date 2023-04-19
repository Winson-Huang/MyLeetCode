/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int indexToCover = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[indexToCover++] = nums[i];
            }
        }
        return indexToCover;
    }
}
// @lc code=end

