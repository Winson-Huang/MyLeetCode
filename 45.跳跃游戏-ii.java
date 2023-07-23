/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;

        int jumpCount = 0;
        int lastCover = 0;
        int cover = 0;

        // the iterations are used to get cover of 1,2,... jumps, but not 
        // zero jump, so shortcut in first line is necessary
        for (int i = 0; i <= lastCover; i++) {
            cover = Math.max(cover, i + nums[i]);

            if (i == lastCover) {
                jumpCount++;
                lastCover = cover;
                if (lastCover >= nums.length - 1) return jumpCount;
            }
        }
        // if cannot arrive, return -1
        // this case wont appear according to description
        return -1;

    }
}
// @lc code=end

