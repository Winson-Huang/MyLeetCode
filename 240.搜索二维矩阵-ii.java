/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // leetcode provides three solutions, this one only use O(1) extra space

        int row = 0;
        int col = matrix[0].length - 1;
        boolean ans = false;

        while (row < matrix.length && col >= 0) {
            int val = matrix[row][col];

            if (val < target) {
                row++;
            } else if (val > target) {
                col--;
            } else {
                ans = true;
                break;
            }

        }
        
        return ans;
    }
}
// @lc code=end

