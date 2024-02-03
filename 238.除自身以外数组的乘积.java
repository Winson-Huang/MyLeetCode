/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {

    // from leetcode official, the thought is similar to prefix sum
    // there is a way to save some space, but the core is same
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length + 1];
        int[] rightProduct = new int[nums.length + 1];
        leftProduct[0] = 1;
        rightProduct[nums.length] = 1;
        
        for (int i = 0; i < nums.length; i++) {
            leftProduct[i + 1] = leftProduct[i] * nums[i];
            rightProduct[nums.length - 1 - i] = rightProduct[nums.length - i] * nums[nums.length - 1 - i];
        }
        
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = leftProduct[i] * rightProduct[i + 1];
        }
        
        return ans;
    }
    
}
// @lc code=end

