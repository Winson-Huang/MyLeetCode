/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start


class Solution {
    // 在本仓库中，解法应该尽量清晰，时空复杂度只需要 big O 等价即可，一些小的，影响可读性，
    // 影响逻辑的直白的优化，应该完全避免。
    public int trap(int[] height) {
        // return trapDpTwoPointer(height);
        return trapMonoticStack(height);
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
    
    // In this solution, outer iteration is popin, while inner iteration is popup
    // not better in space or time but just interesting.
    public int trapMonoticStack(int[] height) {
        // use an array to simulate a stack, the top is at right.
        // the stack stores element indices of height
        int[] stack = new int[height.length];
        int stackTopPointer = -1;
        
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            // popup case
            while (stackTopPointer >= 0 && height[i] >= height[stack[stackTopPointer]]) {
                // if there is only one element in stack, no need to calculate
                // water, just pop up.
                if (stackTopPointer == 0) {
                    stackTopPointer--;
                    break;
                }
                
                // else, need to calculate water
                // store some indices when pop up, for following calc
                int indexAtTop = stack[stackTopPointer--];
                int indexAtTopLeft = stack[stackTopPointer];
                
                sum += (i - indexAtTopLeft - 1) * 
                    (Math.min(height[i], height[indexAtTopLeft]) - height[indexAtTop]);
            }
            
            // pushin case
            stack[++stackTopPointer] = i;
        }
        
        return sum;
    }
    
}
// @lc code=end

