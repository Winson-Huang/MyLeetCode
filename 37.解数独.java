/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    private static final int boardLength = 9;
    // use one int variable to record valid status of one row/column/block
    private int[] column = new int[boardLength];
    private int[] row = new int[boardLength];
    private int[][] block = new int[3][3];

    private ArrayList<int[]> emptyPos = new ArrayList<>();
    private int currentPos = 0;
    private char[][] board;

    void flip(int i, int j, int digit) {
        int flag = 1 << digit;
        row[i] ^= flag;
        column[j] ^= flag;
        block[i / 3][j / 3] ^= flag;
    }
    
    public void solveSudoku(char[][] board) {
        this.board = board;

        // record positions that to be fill
        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength; j++) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0' - 1;
                    flip(i, j, digit);
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

        int currentX = emptyPos.get(currentPos)[0];
        int currentY = emptyPos.get(currentPos)[1];
        // only 9 low bits in candidates may be one-bit, which represents a candidate digit
        // other bits in candidates are zero-bit
        int candidates = ~(row[currentX] | column[currentY] | block[currentX / 3][currentY / 3]) & 0x1FF;
        // comparing to boolean array way, in this way only need to test vaild digits, 
        // instead of 1-9
        while (candidates != 0) {
            // candidate only contains one "one-bit", which is the lowest one-bit in candidates
            int candidate = (candidates & -candidates);
            // for example, 00000100 - 1 = 00000011, which has two bits,
            // and "two" is the index of one-bit in 00000100
            int digit = Integer.bitCount(candidate - 1);

            board[currentX][currentY] = (char)('0' + digit + 1);
            flip(currentX, currentY, digit);
            currentPos++;
            if (backtracking()) {
                return true;
            } else {
                flip(currentX, currentY, digit);
                currentPos--;
            }

            // get rid of the lowest one-bit
            candidates &= (candidates - 1);
        }
        return false;
    }
}
// @lc code=end

