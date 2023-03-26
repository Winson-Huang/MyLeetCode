/*
 * @lc app=leetcode.cn id=744 lang=java
 *
 * [744] 寻找比目标字母大的最小字母
 */

// @lc code=start
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        char ans = letters[0];
        while (l<=r) {
            int mid = l + (r-l)/2;
            if (letters[mid] > target) {
                ans = letters[mid];
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;

    }
}
// @lc code=end

