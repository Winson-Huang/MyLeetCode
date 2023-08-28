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
        Deque<Integer> stackRight = new ArrayDeque<>();
        int[] indexRight = new int[heights.length];
        Arrays.fill(indexRight, heights.length);
        for (int i = 0; i < heights.length; i++) {
            while (!stackRight.isEmpty() && heights[stackRight.peek()] > heights[i]) {
                indexRight[stackRight.peek()] = i;
                stackRight.pop();
            }
            stackRight.push(i);
        }

        Deque<Integer> stackLeft = new ArrayDeque<>();
        int[] indexLeft = new int[heights.length];
        Arrays.fill(indexLeft, -1);
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stackLeft.isEmpty() && heights[stackLeft.peek()] > heights[i]) {
                indexLeft[stackLeft.peek()] = i;
                stackLeft.pop();
            }
            stackLeft.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < indexLeft.length; i++) {
            maxArea = Math.max(maxArea, (indexRight[i] - indexLeft[i] - 1) * heights[i]);
        }

        return maxArea;
    }
}
// @lc code=end

