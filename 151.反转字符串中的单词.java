/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start
class Solution {
    // this problem is interesting, refer to leetcode official for
    // more solutions
    public String reverseWords(String s) {
        int sLen = s.length();

        // to store an temporary extra space
        char[] result = new char[sLen + 1];

        // find first non-space char in s, then for s[first:],
        // every word is followed by 1 or more space
        int first = 0;
        while (s.charAt(first) == ' ') {
            first++;
        }



        int i = sLen - 1;
        int j = 0;
        while (i >= first) {
            // for a word followed by 1 or more space,
            // find start and end of the word
            int wordEnd = i;
            while (wordEnd >=0 && s.charAt(wordEnd) == ' ') {
                wordEnd--;
            }
            int wordStart = wordEnd;
            while (wordStart >=0 && s.charAt(wordStart) != ' ') {
                wordStart--;
            }

            // copy a word from s to result
            for (int k = wordStart + 1; k <= wordEnd; k++) {
                result[j++] = s.charAt(k);
            }
            result[j++] = ' ';

            i = wordStart;
        }

        // from result[] build a string
        j--;
        return new String(result, 0, j);

    }
}
// @lc code=end