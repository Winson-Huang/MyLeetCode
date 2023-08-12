/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start

class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int countZero = 0;
            int countOne = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') countZero++;
                else countOne++;
            }

            for (int i = m; i >= countZero; i--) {
                for (int j = n; j >= countOne; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - countZero][j - countOne] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
// @lc code=end

