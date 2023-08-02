/*
 * @lc app=leetcode.cn id=738 lang=java
 *
 * [738] 单调递增的数字
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int n) {
        // recursion base case
        if (n == 0) return 0;

        // recursion
        int r = n % 10;
        n /= 10;
        int l = n % 10;
        int ans = monotoneIncreasingDigits(l > r ? n - 1 : n);
        if (n > ans) {
            ans = ans * 10 + 9;
        } else {
            ans = ans * 10 + r;
        }
        return ans;
    }
}
// @lc code=end

