/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int[][] F = new int[t.length() + 1][26];
        Arrays.fill(F[t.length()], t.length());
        for (int i = t.length() - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == 'a' + j) {
                    F[i][j] = i;
                } else {
                    F[i][j] = F[i + 1][j];
                }
            }
        }

        // process s
        int i = 0;
        for (char sChar : s.toCharArray()) {
            i = F[i][sChar - 'a'];
            if (i == t.length()) {
                return false;
            } else {
                i++;
            }
        }
        return true;
    }
}
// @lc code=end

