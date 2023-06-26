/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    boolean[][] board;
    List<List<String>> ans;
    LinkedList<String> path;

    public List<List<String>> solveNQueens(int n) {
        this.board = new boolean[n][n];
        ans = new ArrayList<>();
        path = new LinkedList<>();

        backtracking();

        return ans;
    }

    void backtracking() {
        if (path.size() == board.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (!isValid(path.size(), i)) {
                continue;
            }

            board[path.size()][i] = true;
            path.offerLast(genLine(i));
            backtracking();
            path.pollLast();
            board[path.size()][i] = false;
        }
    }

    boolean isValid(int i, int j) {
        // no need to check row
        // check column
        for (int k = 0; k < i; k++) {
            if (board[k][j]) return false;
        }
        // check lefttop
        for (int k = i - 1, l = j - 1; k >=0 && l >= 0; k--, l--) {
            if (board[k][l]) return false;
        }
        // check righttop
        for (int k = i - 1, l = j + 1; k >=0  && l < board.length; k--, l++) {
            if (board[k][l]) return false;
        }
        return true;
    }

    String genLine(int index) {
        StringBuilder sb = new StringBuilder(board.length);
        for (int i = 0; i < board.length; i++) {
            sb.append('.');
        }
        sb.setCharAt(index, 'Q');
        return sb.toString();
    }

}
// @lc code=end

