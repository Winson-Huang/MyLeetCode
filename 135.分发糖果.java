/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        // According to description, ratings.length > 0 
        int sum = 1;
        int candy = 1;
        int incLen = 1;
        int decLen = 0;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                decLen = 0;
                if (ratings[i] == ratings[i - 1]) {
                    candy = 1;
                } else {
                    candy++;
                }
                incLen = candy;
                sum += candy;
            } else {
                decLen++;
                if (decLen == incLen) {
                    decLen++;
                }
                sum += decLen;

                candy = 1;
            }

        }


        return sum;
    }
}
// @lc code=end

