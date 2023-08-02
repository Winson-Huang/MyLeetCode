/*
 * @lc app=leetcode.cn id=738 lang=java
 *
 * [738] 单调递增的数字
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int n) {
        // 从右往左处理，width 表示结果中右边数字 9 的数量
        int n_store = n;
        int widthNine = 0;

        int prePos = n % 10;
        n /= 10;
        int curPos;

        // 迭代中处理的是从右往左第 i 位数字
        // 对于数字 123，prePos 是 3，i = 1 表示处理 2
        int i = 1;
        while (n > 0) {
            curPos = n % 10;
            if (curPos > prePos) {
                curPos--;
                widthNine = i;
            }
            prePos = curPos;
            i++;
            n /= 10;
        }

        if (widthNine == 0) {
            return n_store;
        } else {
            int MOD = (int) Math.pow(10, widthNine);
            return n_store - (n_store % MOD) - 1;
        }

    }
}
// @lc code=end

