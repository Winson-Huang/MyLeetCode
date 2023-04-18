import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] charTable = new int[26];
        Arrays.fill(charTable, 0);
        for (char c : magazine.toCharArray()) {
            charTable[c - 'a'] += 1;
        }
        for (char c : ransomNote.toCharArray()) {
            charTable[c - 'a'] -= 1;
        }
        for (int i : charTable) {
            if (i < 0) return false;
        }
        return true;
    }
}
// @lc code=end

