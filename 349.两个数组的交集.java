import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> interSection = new HashSet<>();
        HashSet<Integer> firstSet = new HashSet<>();

        for (int tmpi : nums1) {
            firstSet.add(tmpi);
        }

        for (int tmpi : nums2) {
            if (firstSet.contains(tmpi)) {
                interSection.add(tmpi);
            }
        }

        int[] ans = new int[interSection.size()];
        int i = 0;
        for (Integer tmpI : interSection) {
            ans[i++] = tmpI;
        }
        return ans;
    }
}
// @lc code=end

