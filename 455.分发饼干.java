import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int happyChildrenCount = 0;
        int sIndex = 0;

        for (int gi : g) {
            while (sIndex < s.length && s[sIndex] < gi) {
                sIndex++;
            }

            // only if there is cookie left, a child can be happy
            // s[sIndex] >= gi is not right, may cause "out of range"
            if (sIndex < s.length) {
                happyChildrenCount++;
                sIndex++;
            } else {
                // run out of cookie, just finish it
                break;
            }
        }
        return happyChildrenCount;
    }
}
// @lc code=end

