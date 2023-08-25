/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start

import java.util.Deque;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new LinkedList();
        for (int i = 0; i < nums.length * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                result[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }

        return result;
    }
}
// @lc code=end

