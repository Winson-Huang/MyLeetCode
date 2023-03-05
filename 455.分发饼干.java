import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int sLength = s.length;
        int countChild = 0;
        int sIndex = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int gi : g) {
            while (sIndex < sLength && s[sIndex] < gi) {
                sIndex++;
            }
            // condition in if cannot be s[sIndex] >= gi, because sIndex may ge
            // sLength and s[sIndex] will throw exception
            if (sIndex < sLength) {
                countChild++;
                sIndex++;
            } else {
                break;
            }
        }
        return countChild;
    }
}
// @lc code=end

