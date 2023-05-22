import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    boolean[][] flagPalindrome;
    List<List<String>> ans;
    LinkedList<String> path;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        calFlag(s);
        backtracking(s, 0);
        return ans;
    }

    void backtracking(String s, int startindex) {
        if (startindex == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = startindex; i < s.length(); i++) {
            if (flagPalindrome[startindex][i]) {
                path.offerLast(s.substring(startindex, i+1));
                backtracking(s, i+1);
                path.pollLast();
            }
        }
    }

    void calFlag(String s) {
        flagPalindrome = new boolean[s.length()][s.length()];
        for (boolean[] arr : flagPalindrome) {
            Arrays.fill(arr, true);
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                flagPalindrome[i][j] = 
                flagPalindrome[i+1][j-1] && s.charAt(i) == s.charAt(j);
            }
        }
    }
}
// @lc code=end

