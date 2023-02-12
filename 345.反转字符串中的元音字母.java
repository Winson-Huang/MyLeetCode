/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        int length = s.length();
        int i = 0, j = length - 1;
        char[] charSeq = s.toCharArray();
        while (i < j) {
            while (i < length && !isVowel(charSeq[i])) i++;
            while (j >= 0 && !isVowel(charSeq[j])) j--;
            if (i < j) {
                charSeq = swap(charSeq, i, j);
                i++;
                j--;
            }
        }
        return new String(charSeq);
    }
    private char[] swap(char[] cArr, int i, int j) {
        char tmpC = cArr[i];
        cArr[i] = cArr[j];
        cArr[j] = tmpC;
        return cArr;
    }
    
    private static final String vowels = "aeiouAEIOU";

    private boolean isVowel(char c) {
        if (vowels.indexOf(c) == -1) return false;
        return true;
    }
}
// @lc code=end

