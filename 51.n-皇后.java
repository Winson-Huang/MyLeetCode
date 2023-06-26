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
    List<List<String>> ans;
    LinkedList<Integer> path;
    boolean[] column;
    boolean[] slash;
    boolean[] backslash;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        this.column = new boolean[n];
        this.slash = new boolean[2 * n - 1];
        this.backslash = new boolean[2 * n - 1];

        backtracking();

        return ans;
    }

    void backtracking() {
        if (path.size() == column.length) {
            // generate String after finding a complete path, 
            // do not generate String during path
            ans.add(genStrRep(path));
            return;
        }

        for (int i = 0; i < column.length; i++) {
            if (!isValid(path.size(), i)) {
                continue;
            }

            column[i] = true;
            slash[path.size()+i] = true;
            backslash[path.size() - i + column.length - 1] = true;

            path.offerLast(i);
            backtracking();
            path.pollLast();

            column[i] = false;
            slash[path.size()+i] = false;
            backslash[path.size() - i + column.length - 1] = false;
        }
    }

    boolean isValid(int i, int j) {
        // no need to check row
        if (
            !column[j] && !slash[i + j] && 
            !backslash[i - j + column.length - 1]
        ) return true;
        return false;
    }

    List<String> genStrRep(List<Integer> path) {
        StringBuilder sb = new StringBuilder(column.length);
        for (int i = 0; i < column.length; i++) {
            sb.append('.');
        }
        ArrayList<String> pathStrs = new ArrayList<>(column.length);
        for (Integer i : path) {
            sb.setCharAt(i, 'Q');
            pathStrs.add(sb.toString());
            sb.setCharAt(i, '.');
        }
        return pathStrs;
    }

}
// @lc code=end

