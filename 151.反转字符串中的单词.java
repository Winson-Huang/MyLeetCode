/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        int sLen = s.length();
        int i = sLen - 1;
        // s contains at least 1 word, find first word
        int first = 0;
        while (s.charAt(first) == ' ') first++;

        char[] ans = new char[sLen + 1];
        int j = 0; // j will grow to last non-space in ans

        while (i >= first) {
            int indexToSkipSpace = i;
            while (indexToSkipSpace >=0 && s.charAt(indexToSkipSpace) == ' ') {
                indexToSkipSpace--;
            }

            int indexToGetWord = indexToSkipSpace;
            while (indexToGetWord >= 0 && s.charAt(indexToGetWord) != ' ') {
                indexToGetWord--;
            }

            for (int k = indexToGetWord+1; k <= indexToSkipSpace; k++) {
                ans[j++] = s.charAt(k);
            }
            ans[j++] = ' ';

            i = indexToGetWord;
        }

        j--;

        return new String(ans, 0, j);

    }
}
// @lc code=end