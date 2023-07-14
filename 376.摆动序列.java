/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) return 1;

        int count = 1;
        int prediff = 0;
        int curdiff = 0;

        for (int j = 1; j < nums.length; j++) {
            curdiff = nums[j] - nums[j - 1];
            if (
                prediff <= 0 && curdiff > 0 ||
                prediff >= 0 && curdiff < 0
            ) {
                count++;
                prediff = curdiff;
            }
        }

        return count;
    }
}
// @lc code=end

