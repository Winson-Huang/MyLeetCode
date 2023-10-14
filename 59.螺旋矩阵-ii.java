/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int init = 1;
        // init 存储着每次开始填充一圈时使用的初始值，赋给左上角的元素
        for (int i = 0; i < n / 2; i++) {
            int len = n - 1 - i * 2;
            init = fillSides(result, i, i, init, len);
        }
        // 如果 n 为奇数，则需要单独给最中间的元素赋值
        if (n % 2 == 1) {
            result[n / 2][n / 2] = n * n;
        }

        return result;
    }
    // 每次填充一圈，从最外层开始。
    public int fillSides(int[][] matrix, int x, int y, int init, int len) {
        for (int i = 0; i < len; i++) {
            matrix[x][y + i] = init + i;
            matrix[x + i][y + len] = init + len + i;
            matrix[x + len][y + len - i] = init + 2 * len + i;
            matrix[x + len - i][y] = init + 3 * len + i;
        }
        return init + 4 * len;
    }
}
// @lc code=end

