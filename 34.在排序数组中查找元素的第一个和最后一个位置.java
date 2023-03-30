/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int pos[] = new int[] {-1, -1};
        if (nums.length == 0) return pos;

        int first = binSearch(nums, target, true);
        int last = binSearch(nums, target, false) - 1;

        if (
            first <= last && last < nums.length && nums[first] == target
        ) {
            pos[0] = first;
            pos[1] = last;
        }
        return pos;
    }

    private int binSearch(int[] nums, int target, boolean containEqual) {
        int low = 0, high = nums.length - 1, ans = nums.length;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] > target || (containEqual && nums[mid] >= target)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
// @lc code=end

