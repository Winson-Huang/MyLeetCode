/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文串 II
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        int length = s.length();
        int i = 0, j = length - 1;
        char[] chrSeq = s.toCharArray();
        while (i < j) {
            if (chrSeq[i] != chrSeq[j]) {
                return (isPalindrome(chrSeq, i, j-1) || isPalindrome(chrSeq, i+1, j)); 
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isPalindrome(char[] chrSeq, int i, int j) {
        while (i < j) {
            if (chrSeq[i] != chrSeq[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
// @lc code=end

