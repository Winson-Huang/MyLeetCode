/*
 * @lc app=leetcode.cn id=2454 lang=java
 *
 * [2454] 下一个更大元素 IV
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[] secondGreaterElement(int[] nums) {
        // use array to simulate stacks
        int[][] stacks = new int[2][nums.length];

        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        int p1 = -1;
        int p0 = -1;
        for (int i = 0; i < nums.length; i++) {
            while (p1 >= 0 && nums[stacks[1][p1]] < nums[i]) {
                result[stacks[1][p1]] = nums[i];
                p1--;
            }

            int count = 0;
            while (p0 >= 0 && nums[stacks[0][p0]] < nums[i]) {
                count++;
                p0--;
            }
            System.arraycopy(stacks[0], p0 + 1, stacks[1], p1 + 1, count);
            p1 += count;
            stacks[0][++p0] = i;
        }

        return result;
    }
}
// @lc code=end

