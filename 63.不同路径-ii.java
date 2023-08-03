/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        // similar to Problem #62, 
        // but init of left edge and top edge need attention
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            if (dp[0] != 0) {
                dp[0] = (1 - obstacleGrid[i][0]);
            }
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }

        return dp[n - 1];

    }
}
// @lc code=end

