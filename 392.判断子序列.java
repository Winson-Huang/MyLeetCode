/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int iS = 0;
        int lenS = s.length();
        // if there are plenty of S, maintain two array of lenS and iS, and
        // test every S in one iteration
        if (lenS == 0) return true;
        for (char cT : t.toCharArray()) {
            if (cT == s.charAt(iS)) {
                iS++;
                if (iS == lenS) 
                    return true;
            }
        }
        return false;
    }
}
// @lc code=end

