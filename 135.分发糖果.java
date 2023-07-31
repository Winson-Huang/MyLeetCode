/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        // According to description, ratings.length > 0 

        // calculate minimal candy only considering from left to right
        int[] leftMins = new int[ratings.length];
        leftMins[0] = 1;
        for (int i = 1; i < leftMins.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftMins[i] = leftMins[i - 1] + 1;
            } else {
                leftMins[i] = 1;
            }
        }

        int sum = Math.max(1, leftMins[leftMins.length - 1]);
        int candy = 1;
        for (int i = leftMins.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy++;
            } else {
                candy = 1;
            }
            sum += Math.max(candy, leftMins[i]);
        }

        return sum;
    }
}
// @lc code=end

