/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {

        // only need to store counts of $5 and $10 changes
        int[] changeCounts = new int[2];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                changeCounts[0]++;
            } else if (bills[i] == 10) {
                changeCounts[0]--;
                changeCounts[1]++;
            } else { // this case must be $20
                changeCounts[0]--;
                // 优先使用 $10 面值的零钱
                if (changeCounts[1] > 0) {
                    changeCounts[1]--;
                } else {
                    changeCounts[0] -= 2;
                }
            }
            if (changeCounts[0] < 0 || changeCounts[1] < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

