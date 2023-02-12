/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // if index <= LeZeroIn, element <= 0
        int LeZeroIn = -1;
        // if index < LeOneEx, element <= 1
        int LeOneEx = 0;
        // if index >= GeTwoIn, element >= 2
        int GeTwoIn = nums.length;
        while (LeOneEx < GeTwoIn) {
            if (nums[LeOneEx] == 0) {
                swap(nums, ++LeZeroIn, LeOneEx++);
            } else if (nums[LeOneEx] == 1) {
                LeOneEx++;
            } else {
                swap(nums, --GeTwoIn, LeOneEx);
            }
        }
    }
    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
// @lc code=end

