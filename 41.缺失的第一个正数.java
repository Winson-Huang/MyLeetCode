/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        
        // from leetcode official
        int max = nums.length;

        // restore elements
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            while ((x > 0 && x <= max) && nums[x - 1] != x) {
                int tmp = nums[x - 1];
                nums[x - 1] = nums[i];
                nums[i] = tmp;
                
                x = nums[i];
            }
        }
        
        // scan for answer
        int ans = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ans = i + 1;
                break;
            }
        }
        return ans;

    }
}
// @lc code=end

