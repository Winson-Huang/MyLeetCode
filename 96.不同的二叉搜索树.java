/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 0; j < i / 2; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
            dp[i] += dp[i];
            if (i % 2 == 1) {
                dp[i] += dp[i / 2] * dp[i / 2];
            }
        }
        return dp[n];
    }
}
// @lc code=end

