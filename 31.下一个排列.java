/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }

        if (i > 0) {
            // swap (i - 1) and item in [i,] that greater than it
            for (int j = nums.length - 1; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[i - 1];
                    nums[i - 1] = tmp;
                    break;
                }
            }
        }

        // reverse [i,]
        int phead = i;
        int ptail = nums.length - 1;
        while (phead < ptail) {
            int tmp = nums[phead];
            nums[phead] = nums[ptail];
            nums[ptail] = tmp;
            phead++;
            ptail--;
        }
    }
}
// @lc code=end

