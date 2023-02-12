/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        m--;
        n--;
        while (m >=0 || n >= 0) {
            if (m >= 0 && n >=0) {
                if (nums1[m] > nums2[n]) {
                    nums1[i--] = nums1[m--];
                } else {
                    nums1[i--] = nums2[n--];
                }
            } else if (m < 0) {
                while (n >= 0) {
                    nums1[i--] = nums2[n--];
                }
            } else {
                while (m >= 0) {
                    nums1[i--] = nums1[m--];
                }
            }
        }
    }
}
// @lc code=end

