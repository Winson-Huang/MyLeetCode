/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int lenCost = cost.length;
        int a = 0;
        int b = 0;

        int sum = 0;
        for (int i = 2; i <= lenCost; i++) {
            sum = Math.min(a + cost[i - 2], b + cost[i - 1]);
            a = b;
            b = sum;
        }

        return sum;
    }
}
// @lc code=end

