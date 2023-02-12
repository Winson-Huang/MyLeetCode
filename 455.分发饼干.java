import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int count = 0, sIndex = 0;
        for (int gi : g) {
            while (sIndex < s.length && s[sIndex] < gi) {
                sIndex++;
            }
            if (sIndex < s.length) {
                count++;
                sIndex++;
            } else break;
        }
        return count;
    }
}
// @lc code=end

