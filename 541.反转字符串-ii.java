/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] sCharArr = s.toCharArray();
        int i = 0;
        for (i = 0; i + 2 * k <= sCharArr.length; i += 2 * k) {
            reverseSegment(sCharArr, i, k);
        }
        if (i + k <= sCharArr.length) {
            reverseSegment(sCharArr, i, k);
        } else {
            reverseSegment(sCharArr, i, sCharArr.length - i);
        }
        return new String(sCharArr);
    }

    void reverseSegment(char[] arr, int start, int len) {
        for (int i = 0; i < len / 2; i++) {
            char tmp = arr[start + i];
            arr[start + i] = arr[start + len - 1 - i];
            arr[start + len - 1 - i] = tmp;
        }
    }
}
// @lc code=end

