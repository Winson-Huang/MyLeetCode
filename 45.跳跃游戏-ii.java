/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {

    // leetcode official is good enough
    public int jump(int[] nums) {

        int jumpCount = 0;
        int lastCover = 0;
        int cover = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            cover = Math.max(cover, i + nums[i]);

            if (i == lastCover) {
                jumpCount++;
                lastCover = cover;
            }
        }
        return jumpCount;

    }
}
// @lc code=end

