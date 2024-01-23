/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start


class Solution {
    public int trap(int[] height) {
        return trapDp(height);
    }
    
    // just dp
    public int trapDp(int[] height) {
        int sum = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[height.length - 1 - i] = Math.max(
                rightMax[height.length - i], height[height.length - 1 - i]);
        }
        for (int i = 0; i < height.length; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }
    
}
// @lc code=end

