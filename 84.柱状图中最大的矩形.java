/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int largestRectangleArea(int[] heights) {
        // monotonic stack one time scan

        Deque<Integer> stack = new ArrayDeque<>();
        int[] indexRight = new int[heights.length];
        Arrays.fill(indexRight, heights.length);
        int[] indexLeft = new int[heights.length];
        Arrays.fill(indexLeft, -1);

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                indexRight[stack.peek()] = i;
                stack.pop();
            }
            indexLeft[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < indexLeft.length; i++) {
            maxArea = Math.max(maxArea, (indexRight[i] - indexLeft[i] - 1) * heights[i]);
        }

        return maxArea;
    }
}
// @lc code=end

