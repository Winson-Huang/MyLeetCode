/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n <= 3) return n;
        int countLowerTwo = 2;
        int countLowerOne = 3;

        for (int i = 4, sum = 0; i <= n; i++) {
            sum = countLowerTwo + countLowerOne;
            countLowerTwo = countLowerOne;
            countLowerOne = sum;
        }

        return countLowerOne;
    }
}
// @lc code=end

