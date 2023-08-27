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
            while (pointer >= 0 && height[stack[pointer]] <= height[i]) {
                // pop out
                int top = stack[pointer--];
                // before poping out there is only one element
                if (pointer == -1) {
                    break;
                }

                // else, need to add rain water to sum
                int topLeft = stack[pointer];
                sum += (Math.min(height[topLeft], height[i]) - height[top])
                        * (i - 1 - topLeft);
            }
            // push in
            stack[++pointer] = i;
        }

        return sum;
    }
}
// @lc code=end

