/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start


class Solution {
    public int trap(int[] height) {
        // monotonic stack
        // use an array to simulate stack
        int[] stack = new int[height.length];
        int pointer = -1;

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            while (pointer > 0 && height[stack[pointer]] <= height[i]) {
                sum += (Math.min(height[stack[pointer - 1]], height[i])
                        - height[stack[pointer]])
                        * (i - 1 - stack[pointer - 1]);
                pointer--;
            }
            if (pointer == 0 && height[stack[pointer]] <= height[i]) {
                pointer--;
            }
            stack[++pointer] = i;
        }

        return sum;
    }
}
// @lc code=end

