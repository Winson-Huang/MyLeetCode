/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int[] fail = new int[len];
        fail[0] = -1;
        for (int j = -1, i = 1; i < len; i++) {
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = fail[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                j++;
            }
            fail[i] = j;
        }

        if (fail[len - 1] != -1 && len % (len - fail[len - 1] - 1) == 0) {
            return true;
        }
        return false;
    }
}
// @lc code=end

