/*
 * @lc app=leetcode.cn id=540 lang=java
 *
 * [540] 有序数组中的单一元素
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        /**
         * leetcode official
         */
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r-l)/2;
            mid -= mid & 1;
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
// @lc code=end

