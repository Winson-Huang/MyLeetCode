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
        return largestRectangleAreaMonotonicStack(heights);
    }
    
    int largestRectangleAreaMonotonicStack(int[] height) {
        // monotonic stack one time scan
        
        // get index of first lower element in left (indexLeft) and first non-higher element in right (indexRight) using
        // monotonic stack
        Deque<Integer> monotonicStack = new ArrayDeque<>();
        
        // prepare arrays
        int[] indexLeft = new int[height.length];
        int[] indexRight = new int[height.length];
        Arrays.fill(indexLeft, -1);
        Arrays.fill(indexRight, height.length);
        
        // monotonic push and pop
        for (int i = 0; i < height.length; i++) {
            while (!monotonicStack.isEmpty() && height[monotonicStack.peek()] >= height[i]) {
                indexRight[monotonicStack.pop()] = i;
            }
            indexLeft[i] = monotonicStack.isEmpty() ? -1 : monotonicStack.peek();
            monotonicStack.push(i);
        }

        // get max area
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (indexRight[i] - indexLeft[i] - 1));
        }
        return maxArea;
    }
    
}
// @lc code=end

