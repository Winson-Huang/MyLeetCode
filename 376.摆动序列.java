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
        int lastNum = nums[0];

        for (int j = 1; j < nums.length; j++) {
            if (
                prediff <= 0 && nums[j] - lastNum > 0 ||
                prediff >= 0 && nums[j] - lastNum < 0
            ) {
                count++;
                prediff = nums[j] - lastNum;
                lastNum = nums[j];
            } else {
                lastNum = nums[j];
            }
        }

        return count;
    }
}
// @lc code=end

