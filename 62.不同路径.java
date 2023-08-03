/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        if (m > n) {
            int tmp = n;
            n = m;
            m = tmp;
        }

        // m is smaller than n now, use n or m as size of dp are both ok
        // use m, space needed is smaller but 2-D iteration will be 
        // small iteration nested in big iteration, which may be slower,
        // use n, vice verse
        int[] dp = new int[m];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[m - 1];
    }
}
// @lc code=end

