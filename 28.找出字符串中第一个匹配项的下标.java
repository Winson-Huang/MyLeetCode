import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 找出字符串中第一个匹配项的下标
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {

        // fail[i] is j, then needle[0, j] == needle[i-j, i]
        int lenNee = needle.length();
        int[] fail = new int[lenNee - 1];

        Arrays.fill(fail, -1);
        for (int j = -1, i = 1; i < fail.length; i++) {
            while (j != -1 && needle.charAt(j + 1) != needle.charAt(i)) {
                j = fail[j];
            }
            if (needle.charAt(j + 1) == needle.charAt(i)) {
                j++;
            }
            fail[i] = j;
        }

        for (int j = -1, i = 0; i < haystack.length(); i++) {
            while (j != -1 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = fail[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            } 
            if (j == lenNee - 1) {
                return i - j;
            }
        }

        return -1;
    }
}
// @lc code=end

