/*
 * @lc app=leetcode.cn id=540 lang=java
 *
 * [540] 有序数组中的单一元素
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        /**
         * version 1
         * 先判断 mid 是否是所求元素，如果不是，则一定有一个相等的邻居，让 mid 指向
         * 这对邻居的左元素。
         * 然后判断这对邻居之前的元素个数是否为偶数，若是，则说明所求元素在这对邻居之后。
         */
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r-l)/2;
            if (nums[mid] == nums[mid-1]) {
                mid--;
            } else if (nums[mid] == nums[mid+1]) {
            } else {
                return nums[mid];
            }
            if ((mid - l) % 2 == 0) {
                l = mid + 2;
            } else {
                r = mid - 1;
            }
        }
        return nums[l];
    }
}
// @lc code=end

