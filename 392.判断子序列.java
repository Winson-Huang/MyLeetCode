/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int lenT = t.length();
        int[][] F = new int[lenT+1][26];
        for (int i = 0; i < 26; i++) {
            F[lenT][i] = lenT;
        }
        for (int i = lenT-1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == 'a'+j) {
                    F[i][j] = i;
                } else {
                    F[i][j] = F[i+1][j];
                }
            }
        }

        // process s
        int i = 0;
        for (char cS : s.toCharArray()) {
            int dest = F[i][cS - 'a'];
            if (dest == lenT) {
                return false;
            } else {
                i = dest + 1;
            }
        }
        return true;
    }
}
// @lc code=end

