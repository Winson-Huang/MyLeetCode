/*
 * @lc app=leetcode.cn id=665 lang=java
 *
 * [665] 非递减数列
 */

// @lc code=start
class Solution {
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        if (len < 3)
            return true;

        // this boolean can be replaced by an int
        boolean hasChanged = false;
        if (nums[1] < nums[0]) {
            nums[0] = nums[1];
            hasChanged = true;
        }
        for (int i = 2; i < len; i++) {
            if (nums[i] < nums[i-1]) {
                if (hasChanged)
                    return false;
                if (nums[i] >= nums[i-2]) {
                    nums[i-1] = nums[i];
                } else {
                    nums[i] = nums[i-1];
                }
                hasChanged = true;
            }
        }
        return true;
    }
}
// @lc code=end

