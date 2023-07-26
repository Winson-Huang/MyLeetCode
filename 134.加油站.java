/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int minSum = 0;
        int minSumi = -1;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < minSum) {
                minSum = sum;
                minSumi = i;
            }
        }
        if (sum < 0) return -1;
        else return minSumi + 1;
    }
}
// @lc code=end

