import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        // cal sum
        // test
        HashSet<Integer> sumSet = new HashSet<>();
        while (n != 1 && !sumSet.contains(n)) {
            sumSet.add(n);
            n = sumOfSquares(n);
        }
        return n == 1;
    }
    public int sumOfSquares(int input) {
        int sum = 0;
        while (input != 0) {
            sum += Math.pow(input % 10, 2);
            input = input / 10;
        }
        return sum;
    }
}
// @lc code=end

