/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        // dynamic programming: two pointers
        // two pointers method is actually a variant of dp
        int leftMax = height[0];
        int leftPointer = 0;
        int rightMax = height[height.length - 1];
        int rightPointer = height.length - 1;

        int sum = 0;
        while (leftPointer < rightPointer) {
            if (leftMax < rightMax) {
                leftPointer++;
                leftMax = Math.max(leftMax, height[leftPointer]);
                sum += leftMax - height[leftPointer];
            } else {
                rightPointer--;
                rightMax = Math.max(rightMax, height[rightPointer]);
                sum += rightMax - height[rightPointer];
            }
        }

        return sum;
    }
}
// @lc code=end

