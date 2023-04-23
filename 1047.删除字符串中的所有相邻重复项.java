/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        char[] arrS = s.toCharArray();
        int top = -1; // -1 means stack is empty
        for (int i = 0; i < arrS.length; i++) {
            if (top == -1 || arrS[top] != arrS[i]) {
                arrS[++top] = arrS[i];
            } else {
                top--;
            }
        }
        return new String(arrS, 0, top+1);
    }
}
// @lc code=end

