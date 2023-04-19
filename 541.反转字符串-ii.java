/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int i = 0;
        for (i = 0; i + 2 * k - 1 < arr.length; i = i + 2 * k) {
            reverse(arr, i, k);
        }
        if (i + k - 1 < arr.length) {
            reverse(arr, i, k);
        } else {
            reverse(arr, i, arr.length - i);
        }
        return new String(arr);
    }
    void reverse(char[] arr, int start, int len) {
        int i = start, j = start + len - 1;
        while (i < j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i++] ^= arr[j--];
        }
    }
}
// @lc code=end

