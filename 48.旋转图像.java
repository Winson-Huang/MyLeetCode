/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        
        // from leetcode official
        int n = matrix.length;
        int rightBorder = (n + 1) / 2;
        int bottomBorder = n / 2;

        for (int i = 0; i < bottomBorder; i++) {
            for (int j = 0; j < rightBorder; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
        
        return;
    }
}
// @lc code=end

