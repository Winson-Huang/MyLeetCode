/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public void setZeroes(int[][] matrix) {
        // from leetcode official, only O(1) extra space

        int m = matrix.length;
        int n = matrix[0].length;

        // scan first column and first row
        boolean hasZeroAtFirstCol = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                hasZeroAtFirstCol = true;
                break;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                matrix[0][0] = 0;
                break;
            }
        }
        
        
        // scan other space
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        
        // set zeros
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }
        if (hasZeroAtFirstCol) {
            for (int j = 0; j < m; j++) {
                matrix[j][0] = 0;
            }
        }
        
        
    }
}
// @lc code=end

