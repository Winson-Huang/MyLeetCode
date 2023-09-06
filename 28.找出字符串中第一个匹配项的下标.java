import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 找出字符串中第一个匹配项的下标
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {

        // fail[i] is j, means needle[0, j] equals needle[i-j, i]
        // j >= -1 and j <= i - 1
        int[] fail = new int[needle.length() - 1];
        Arrays.fill(fail, -1);

        for (int j = -1, i = 1; i < fail.length; i++) {
            //in beginning of every iteration in this for-loop,
            // j always stores fail[i - 1]
            while (j != -1 && needle.charAt(j + 1) != needle.charAt(i)) {
                j = fail[j];
            }

            if (needle.charAt(j + 1) == needle.charAt(i)) {
                j++;
            }

            fail[i] = j;
        }


        for (int j = -1, i = 0; i < haystack.length(); i++) {

            while (j != -1 && needle.charAt(j + 1) != haystack.charAt(i)) {
                j = fail[j];
            }

            if (needle.charAt(j + 1) == haystack.charAt(i)) {
                j++;
            }

            if (j == needle.length() - 1) {
                return i - j;
            }
        }

        return -1;
    }
}
// @lc code=end

