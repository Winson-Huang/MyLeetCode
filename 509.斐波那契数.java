/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        if (n < 2) return n;

        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        int sum = 0;
        for (int i = 2; i < n + 1; i++) {
            sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}
// @lc code=end

