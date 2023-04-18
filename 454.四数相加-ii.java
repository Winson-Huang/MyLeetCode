import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> indexOfSum = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                indexOfSum.put(sum, indexOfSum.getOrDefault(sum, 0) + 1);
            }
        }

        int ans = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                int need = 0 - (i + j);
                ans += indexOfSum.getOrDefault(need, 0);
            }
        }

        return ans;
    }
}
// @lc code=end

