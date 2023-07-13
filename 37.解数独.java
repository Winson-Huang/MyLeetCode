/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    private static final int boardLength = 9;
    // use boolean array to record valid status
    private boolean[][] column = new boolean[boardLength][boardLength];
    private boolean[][] row = new boolean[boardLength][boardLength];
    private boolean[][][] block = new boolean[3][3][boardLength];

    private ArrayList<int[]> emptyPos = new ArrayList<>();
    private int currentPos = 0;
    private char[][] board;
    
    public void solveSudoku(char[][] board) {
        this.board = board;

        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength; j++) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0' - 1;
                    row[i][digit] = true;
                    column[j][digit] = true;
                    block[i / 3][j / 3][digit] = true;
                } else {
                    emptyPos.add(new int[]{i, j});
                }
            }
        }

        backtracking();
    }

    boolean backtracking() {
        if (currentPos == emptyPos.size()) {
            return true;
        }
        int[] currentXy = emptyPos.get(currentPos);
        for (int i = 0; i < boardLength; i++) {
            if (
                row[currentXy[0]][i] || column[currentXy[1]][i] ||
                block[currentXy[0] / 3][currentXy[1] / 3][i]
            ) {
                continue;
            } else {
                board[currentXy[0]][currentXy[1]] = (char)('0' + i + 1);
                row[currentXy[0]][i] = true; 
                column[currentXy[1]][i] = true;
                block[currentXy[0] / 3][currentXy[1] / 3][i] = true;
                currentPos++;
                if (backtracking()) {
                    return true;
                } else {
                    // no need to reset board[x][y] to '.', because
                    // empty positions are stored in emptyPos
                    row[currentXy[0]][i] = false; 
                    column[currentXy[1]][i] = false;
                    block[currentXy[0] / 3][currentXy[1] / 3][i] = false;
                    currentPos--;
                }
            }
        }
        return false;
    }
}
// @lc code=end

