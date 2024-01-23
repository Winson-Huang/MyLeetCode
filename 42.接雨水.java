/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start


class Solution {
    public int trap(int[] height) {
        return trapDpTwoPointer(height);
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
    
    // two pointer, is a variant of dp, but can save space from O(n) to O(1)
    public int trapDpTwoPointer(int[] height) {
        int sum = 0;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int leftPointer = 0, rightPointer = height.length - 1;
        while (leftPointer < rightPointer) {
            if (leftMax < rightMax) {
                sum += leftMax - height[leftPointer];
                leftPointer++;
                leftMax = Math.max(leftMax, height[leftPointer]);
            }
            else {
                sum += rightMax - height[rightPointer];
                rightPointer--;
                rightMax = Math.max(rightMax, height[rightPointer]);
            }
        }
        return sum;
    }
    
}
// @lc code=end

