/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        // do not use result[0], to simplify calculation of index in iteration
        int[] dp = new int[n + 1];
        dp[1] = 1;

        int result = 0;
        for (int i = 2, max = 0; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, j * dp[i - j]);
            }
            result = max;

            max = Math.max(i, max);
            dp[i] = max;
        }
        return result;
    }
}
// @lc code=end

