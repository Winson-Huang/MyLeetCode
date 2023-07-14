/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int count = 1;
        int i = 1;

        while (i < nums.length && nums[i] == nums[0]) {
            i++;
        }
        if (i >= nums.length) {
            return count;
        }

        count++;
        boolean needPosDelta = true;
        if (nums[i] - nums[0] > 0) {
            needPosDelta = false;
        }

        int lastNum = nums[i];
        for (int j = i + 1; j < nums.length; j++) {
            if (
                needPosDelta && nums[j] - lastNum > 0 ||
                !needPosDelta && nums[j] - lastNum < 0
            ) {
                count++;
                lastNum = nums[j];
                needPosDelta = !needPosDelta;
            } else {
                lastNum = nums[j];
            }
        }

        return count;
    }
}
// @lc code=end

